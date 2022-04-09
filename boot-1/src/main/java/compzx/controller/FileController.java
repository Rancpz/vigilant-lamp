package compzx.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        // 获取文件名称的后缀
        String extension = FilenameUtils.getExtension(filename);
        String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;
        // 获取文件要上传的服务器相对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        // 根据日期生成目录
        LocalDate now = LocalDate.now();
        File dateDir = new File(realPath, now.toString());
        // 如果目录不存在，则创建该目录，存在不做操作
        if (!dateDir.exists()) dateDir.mkdirs();

        // 将文件上传到服务器的某个路径  idea默认不会将空目录进行编译
        file.transferTo(new File(dateDir, newFileName));
        return "file";
    }
}
