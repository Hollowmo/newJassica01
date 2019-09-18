package com.jassica.jassica.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Lenovo on 2019/3/24.
 */
@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String img;
    @Property
    private String name;
    @Property
    private String author;
    @Generated(hash = 281345634)
    public DbBean(Long id, String img, String name, String author) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.author = author;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
  
   
}
