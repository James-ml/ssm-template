package cn.jims.entity;

import cn.jims.controller.validation.ValidGroup1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 开启二级缓存，实现序列化接口 implements Serializable
 */
public class Book {
    private Long bookid;
    //表单校验参数
    @Size(min = 1, max = 10, message = "{book.name.length.error}", groups = {ValidGroup1.class})
    private String name;
    @NotNull(message = "{book.number.idNull}", groups = {ValidGroup1.class})
    private Integer number;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}