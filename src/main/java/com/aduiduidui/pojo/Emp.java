package com.aduiduidui.pojo;


public class Emp {

  private long id;
  private String username;
  private String password;
  private String name;
  private long gender;
  private String image;
  private long job;
  private java.sql.Date entrydate;
  private long deptId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public long getJob() {
    return job;
  }

  public void setJob(long job) {
    this.job = job;
  }


  public java.sql.Date getEntrydate() {
    return entrydate;
  }

  public void setEntrydate(java.sql.Date entrydate) {
    this.entrydate = entrydate;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", gender=" + gender +
            ", image='" + image + '\'' +
            ", job=" + job +
            ", entrydate=" + entrydate +
            ", deptId=" + deptId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
