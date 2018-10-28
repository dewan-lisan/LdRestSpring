package com.lisanuldewan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Blog {
    private int id;
    private String title;
    private String content;
    private SimpleDateFormat publishdate;

    public Blog() {}

    public Blog(int id, String title, String content, SimpleDateFormat publishdate){
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
        this.setPublishdate(publishdate);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public SimpleDateFormat getPublishdate() {
        return publishdate;
    }
    public void setPublishdate(SimpleDateFormat publishdate) {
        this.publishdate = publishdate;
    }

    @Override
    public String toString(){
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishdate=" + publishdate.toString() +
                ", content='" + content + '\'' +
                '}';
    }

}
