package com.mc.entity;

public class Res {
    private Integer id;
    private String name;
    private String url;
    private Integer _pid;


    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return name;
    }

    public void setText(String text) {
        this.name = text;
    }

    public Integer get_parentId() {
        return _pid;
    }

    public void set_parentId(Integer _parentId) {
        this._pid = _parentId;
    }
}
