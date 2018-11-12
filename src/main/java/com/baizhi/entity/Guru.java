package com.baizhi.entity;

public class Guru {
    private String id;
    private String sheadpic;
    private String sname;
    private String status;

    public Guru() {
    }

    public Guru(String id, String sheadpic, String sname, String status) {
        this.id = id;
        this.sheadpic = sheadpic;
        this.sname = sname;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSheadpic() {
        return sheadpic;
    }

    public void setSheadpic(String sheadpic) {
        this.sheadpic = sheadpic;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", sheadpic='" + sheadpic + '\'' +
                ", sname='" + sname + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
