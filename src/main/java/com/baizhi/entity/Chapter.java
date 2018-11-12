package com.baizhi.entity;

public class Chapter {
    private String id;
    private String title;
    private String download_url;
    private String size;
    private String duration;
    private String album_id;

    public Chapter() {
    }

    public Chapter(String id, String title, String download_url, String size, String duration, String album_id) {
        this.id = id;
        this.title = title;
        this.download_url = download_url;
        this.size = size;
        this.duration = duration;
        this.album_id = album_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", download_url='" + download_url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", album_id='" + album_id + '\'' +
                '}';
    }
}
