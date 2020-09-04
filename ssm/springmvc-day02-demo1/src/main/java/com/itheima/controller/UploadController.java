package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/23 16:20
 *
 ****/
@Controller
@RequestMapping(value = "/upload")
public class UploadController {


    /***
     * 远程文件上传
     * @return
     */
    @RequestMapping(value = "/remote/image")
    public String remoteUpload(MultipartFile file) throws IOException {
        //远程文件上传路径
        String path = "http://localhost:18082/uploads/";

        //随机数
        String newName = "No"+ (int)( Math.random()*1000 );

        //获取文件真实名字
        String realName = file.getOriginalFilename();
        String suffix = StringUtils.getFilenameExtension(realName);

        //创建远程上传的客户端对象   依赖
        Client client = Client.create();

        //创建文件资源传输对象
        WebResource resource = client.resource(path+newName+"."+suffix);

        //文件上传
        resource.put(file.getBytes());
        return "add_user";
    }


    /***
     * 传统文件上传方式
     * @return
     */
    @RequestMapping(value = "/servlet/image")
    public String servletUpload(HttpServletRequest request,HttpSession session) throws Exception {

        //获取images的目录路径
        String realPath = session.getServletContext().getRealPath("/images");

        //UUID
        String randName = UUID.randomUUID().toString().replace("-","");



        //文件上传磁盘处理的工厂对象  1G文件--->加载到内存--->超过10M-->将文件切割存放到临时文件夹中
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //文件解析对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        //解析文件上传信息
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);

        //循环判断每个表单对象是否是文件上传表单对象
        for (FileItem fileItem : fileItems) {
            //如果返回true，表示是非文件上传表单，如果返回false,表示是文件上传表单
            boolean bo = fileItem.isFormField();

            if(!bo){
                //文件真实名字
                String fieldName = fileItem.getName();

                //获取扩展名
                String suffix = StringUtils.getFilenameExtension(fieldName);

                //文件上传
                fileItem.write(new File(realPath+"/"+randName+"."+suffix));

                //删除临时文件
                fileItem.delete();
            }
        }
        return "add_user";
    }

    /****
     * MultipartFile:表示接受前台传过来的文件的包装对象
     * @param file
     * @return
     */
    @RequestMapping(value = "/image")
    public String upload(MultipartFile file, HttpSession session) throws IOException {
        //获取images的目录路径
        String realPath = session.getServletContext().getRealPath("/images");

        //文件的名字获取(用户上传的文件真实名字)
        String fileRealName = file.getOriginalFilename();

        //UUID
        String randName = UUID.randomUUID().toString().replace("-","");

        //获取文件后缀   123.jpg
        //StringUtils.getFilenameExtension:获取文件扩展名(后缀)
        String suffix = StringUtils.getFilenameExtension(fileRealName);

        //文件上传
        //transferTo（参数）  参数：要将文件写入到本地的哪个路径  例如：D:/1.jpg
        file.transferTo(new File(realPath+"/"+randName+"."+suffix));
        return "add_user";
    }



}
