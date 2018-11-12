package com.baizhi.entity;

public class Yuser {
    private String id;
    private String password;
    private String farmingo;
    private String nickname;
    private String gender;
    private String photo;
    private String location;
    private String province;
    private String city;
    private String description;
    private int phone;
    private String shangshi;

    public Yuser() {
    }

    public Yuser(String id, String password, String farmingo, String nickname, String gender, String photo, String location, String province, String city, String description, int phone, String shangshi) {
        this.id = id;
        this.password = password;
        this.farmingo = farmingo;
        this.nickname = nickname;
        this.gender = gender;
        this.photo = photo;
        this.location = location;
        this.province = province;
        this.city = city;
        this.description = description;
        this.phone = phone;
        this.shangshi = shangshi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFarmingo() {
        return farmingo;
    }

    public void setFarmingo(String farmingo) {
        this.farmingo = farmingo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getShangshi() {
        return shangshi;
    }

    public void setShangshi(String shangshi) {
        this.shangshi = shangshi;
    }

    @Override
    public String toString() {
        return "Yuser{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", farmingo='" + farmingo + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", phone=" + phone +
                ", shangshi='" + shangshi + '\'' +
                '}';
    }
}
