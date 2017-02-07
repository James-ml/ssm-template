package cn.jims.entity;

import java.util.List;

/**
 * 图书的包装类
 * Created by Jims on 2017/2/7.
 */
public class BookQueryVo {

    //图书信息
    private Book book;

    //为了系统可扩展性，对原始生成的entity进行扩展
    private BookCustom bookCustom;

    //批量图书信息
    private List<BookCustom> BookList;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCustom getBookCustom() {
        return bookCustom;
    }

    public void setBookCustom(BookCustom itemsCustom) {
        this.bookCustom = itemsCustom;
    }

    public List<BookCustom> getBookList() {
        return BookList;
    }

    public void setBookList(List<BookCustom> bookList) {
        BookList = bookList;
    }
}
