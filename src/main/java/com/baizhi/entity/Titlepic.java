package com.baizhi.entity;

public class Titlepic {
    private String id;
    private String thumbnail;
    private String desc;
    private String status;

    public Titlepic() {
    }

    public Titlepic(String id, String thumbnail, String desc, String status) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.desc = desc;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Titlepic{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
