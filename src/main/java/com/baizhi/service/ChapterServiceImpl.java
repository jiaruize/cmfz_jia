package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void insert(Chapter chapter) {
        String album_id = chapter.getAlbum_id();
        Album one = albumDao.findOne(album_id);
        chapter.setId(UUID.randomUUID().toString());
        chapterDao.insert(chapter);
        int set_count = one.getSet_count();
        set_count++;
        albumDao.updatecount(set_count,album_id);

    }
}
