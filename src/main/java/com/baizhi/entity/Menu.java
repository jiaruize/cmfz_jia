package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private String parentld;
    private List<Menu> children=new ArrayList<Menu>();

    public Menu() {
    }

    public Menu(String id, String name, String iconCls, String href, String parentld, List<Menu> children) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parentld = parentld;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParentld() {
        return parentld;
    }

    public void setParentld(String parentld) {
        this.parentld = parentld;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parentld='" + parentld + '\'' +
                ", children=" + children +
                '}';
    }
}
