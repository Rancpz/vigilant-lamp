package compzx.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {

    private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Value("${upload.dir}")
    private String path;

    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws Exception {

        String filename = file.getOriginalFilename();
        // 获取文件名称的后缀
        //String extension = FilenameUtils.getExtension(filename);
        //String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;
        // 获取文件要上传的服务器相对路径

        // 根据日期生成目录
        //LocalDate now = LocalDate.now();
        //File dateDir = new File(realPath, now.toString());
        // 如果目录不存在，则创建该目录，存在不做操作
        //if (!dateDir.exists()) dateDir.mkdirs();

        // 将文件上传到服务器的某个路径  idea默认不会将空目录进行编译
        file.transferTo(new File(path, filename));
        return "index";
    }

    @RequestMapping("down")
//    @ResponseBody
    public void download(String fileName, HttpServletResponse response) throws IOException {
        //log.info("fileName的名字是：", fileName);
        System.out.println(fileName);
        FileInputStream is = new FileInputStream(new File(path, fileName));
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
        response.setContentType("text/plain;charset=utf-8");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        //return "index";
    }
}
