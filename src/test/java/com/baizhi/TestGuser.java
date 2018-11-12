package com.baizhi;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.*;
import com.baizhi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGuser {
    @Autowired
    private GuserService guserService;
    @Autowired
    private  TitlepicService titlepicService;
    @Autowired
    private GuruService guruService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private YuserService yuserService;
    @Test
    public void test1(){
        Guser guser=new Guser();
        guser.setUsername("990214");
        guser.setPassword("990214");
        Guser one = guserService.findOne(guser);
        System.out.println(one);
    }
    @Test
    public void test2(){
        Guser guser=new Guser();
        guser.setId("111");
        guser.setPassword("jia");
        guserService.update(guser);
    }
    @Test
    public void test3(){
        List<Titlepic> byPage = titlepicService.findByPage(1, 2);
        System.out.println(byPage);
    }
    @Test
    public void test4(){
        List<Guru> byPage = guruService.findByPage(1, 2);
        System.out.println(byPage);

    }
    @Test
    public void test5(){
        List<Album> byPage = albumService.findByPage(1, 2);
        System.out.println(byPage);
    }
    @Test
    public void test6(){
        Album album=new Album();
        album.setZthumbnail("eee");
        album.setTitle("eee");
        album.setSet_count(1);
        album.setCreate_date(new Date());
        album.setScore("ee");
        album.setAuthor("eee");
        album.setBroadcast("eee");
        album.setBrief("ee");
        albumService.insert(album);
    }
    @Test
    public void test7(){
        List<Album> albums = albumService.queryAll();
        System.out.println(albums);
    }
    @Test
    public void test8(){
        Yuser yuser=new Yuser();
        yuser.setPassword("qqqq");
        yuserService.insert(yuser);
    }
}
