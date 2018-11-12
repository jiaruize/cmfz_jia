package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Chapter chapter,MultipartFile music, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();
        System.out.println(chapter.getAlbum_id());
        try {
            String realPath = request.getRealPath("/back/datagrid/album/music");
            System.out.println(realPath);
            File file = new File(realPath, music.getOriginalFilename());
            music.transferTo(file);
            chapter.setDownload_url(music.getOriginalFilename());
            chapter.setTitle(music.getOriginalFilename());
            chapter.setSize( music.getSize()+"B");
            chapter.setAlbum_id(chapter.getAlbum_id());
            MP3File read = (MP3File)AudioFileIO.read(file);
            AudioHeader audioHeader = read.getAudioHeader();
            int trackLength = audioHeader.getTrackLength();
            double file_lenght = trackLength / 60;
            chapter.setDuration(file_lenght+"m");

            chapterService.insert(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}

