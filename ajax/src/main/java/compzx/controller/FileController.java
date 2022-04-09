package compzx.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws Exception {
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
        return "index";
    }

    @RequestMapping("/down")
    public void downFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 根据相对路径找到要下载文件的所在的目录
        String realPath = request.getSession().getServletContext().getRealPath("/down");
        // 指定要下载目录下的哪个文件 fileName
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        // 设置输出流的编码
        response.setContentType("text/plain;charset=utf-8");
        // 设置以附件的形式下载到本次 attachment: 以附件的形式下载
        //response.setHeader("content-disposition", "inline;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        // 获取文件的输出流
        ServletOutputStream os = response.getOutputStream();
        // 将文件写出到本地
        // int i;
        // byte[] bytes = new byte[1024];
        // while (true) {
        //     i = is.read(bytes);
        //     if (i == -1) break;
        //     os.write(bytes, 0, i);
        // }
        // is.close();
        // os.close();
        IOUtils.copy(is, os);   // 将文件写出到本地
        // 将流关闭
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
}
