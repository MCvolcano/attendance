package com.mc.entity;


import java.util.LinkedHashSet;
import java.util.Set;

public class Resources {

  private Integer resid;
  private String text;
  private String url;
  private Integer pid;
  private Integer _parentId;
  private Boolean checked = false;

  @Override
  public String toString() {
    return "Resources{" +
            "rrid=" + resid +
            ", text='" + text + '\'' +
            ", url='" + url + '\'' +
            ", parentid=" + pid +
            ", _parentId=" + _parentId +
            ", checked=" + checked +
            ", children=" + children +
            '}';
  }

  public Integer get_parentId() {
    return _parentId;
  }

  public void set_parentId(Integer _parentId) {
    this._parentId = _parentId;
  }

  public Boolean getChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  private Set<Resources> children = new LinkedHashSet<>();

  public Set<Resources> getChildren() {
    return children;
  }

  public void setChildren(Set<Resources> children) {
    this.children = children;
  }

  public Integer getParentid() {
    return pid;
  }

  public void setParentid(Integer parentid) {
    this.pid = parentid;
  }

  public Integer getRrid() {
    return resid;
  }

  public void setRrid(Integer rrid) {
    this.resid = rrid;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
