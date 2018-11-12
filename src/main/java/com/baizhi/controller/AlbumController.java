package com.baizhi.controller;


import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();

        //当前页数据rows:
        List<Album> emps = albumService.findByPage(page, rows);
        //总记录数
        Long totals = albumService.findTotals();
        results.put("total",totals);
        results.put("rows",emps);
        return results;
    }
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Album album, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/datagrid/album/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            album.setZthumbnail("/back/datagrid/album/image/"+img.getOriginalFilename());

            albumService.insert(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("queryAll")
    public @ResponseBody
    List<Album> queryAll(){
        List<Album> queryAll = albumService.queryAll();
        return queryAll;
    }
    @RequestMapping("findOne")
    public @ResponseBody
    Album findOne(String byid){
        System.out.println(byid);
        Album findOne = albumService.findOne(byid);
        System.out.println(findOne);
        return findOne;
    }
    //下载音频
    @RequestMapping("/download")
    public void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(fileName);
        //根据接受文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/back/datagrid/album/music");
        System.out.println(realPath);
        //以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //设置响应头
        response.setHeader("content-disposition",openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //使用IOUtils工具类  拷贝文佳
        IOUtils.copy(is,os);
        //关流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);

    }


}
