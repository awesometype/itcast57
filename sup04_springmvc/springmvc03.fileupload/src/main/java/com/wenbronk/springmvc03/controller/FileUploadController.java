package com.wenbronk.springmvc03.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author wenbronk
 * @Date 2019-07-16
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping("/springmvcFileuploadThrowServer")
    public String springmvcFileuploadThrowServer(MultipartFile uploadFileThrowServer) throws IOException {

        String serverPath = "http://localhost:9009/springmvc03_fileserver_war/uploads";
        String filename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + uploadFileThrowServer.getOriginalFilename();

        // 跨服上传
        Client client = Client.create();
        WebResource webResource = client.resource(serverPath + "/" + filename);
        webResource.put(uploadFileThrowServer.getBytes());

        return "success";
    }

    /**
     * 使用springmvc进行文件上传
     */
    @RequestMapping("/springmvcFileUpload")
    public String springmvcFileUpload(HttpServletRequest request, MultipartFile uploadFile) throws IOException {
        // 设置要上传的位置
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(uploadPath);
        File uploadPathFile = new File(uploadPath);
        if (!uploadPathFile.exists()) {
            boolean mkdirs = uploadPathFile.mkdirs();
        }

        String fileName = uploadFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;

        uploadFile.transferTo(new File(uploadPath, fileName));
        System.out.println("upload file success");
        return "success";
    }

    /**
     * 使用commons进行文件上传
     */
    @RequestMapping("/commonsUpload")
    public String commonsUpload(HttpServletRequest request) throws Exception {
        // 设置要上传的位置
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(uploadPath);
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) uploadFile.mkdirs();

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);

        // 解析request
        List<FileItem> fileItems = fileUpload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField())
                continue;
            String fileName = UUID.randomUUID().toString() + "_" + fileItem.getName();
            fileItem.write(new File(uploadPath, fileName));
            fileItem.delete();
            System.out.println("file upload success");
        }
        return "success";
    }

}
