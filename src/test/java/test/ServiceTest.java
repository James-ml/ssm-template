package test;

import cn.jims.dao.BookMapper;
import cn.jims.dao.BookMapperCustom;
import cn.jims.entity.Book;
import cn.jims.entity.BookCustom;
import cn.jims.entity.BookQueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jims on 2017/2/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class ServiceTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test1() {
        long id = 1003;
        Book book = bookMapper.selectByPrimaryKey(id);
        System.out.println(book);
    }

    @Autowired
    private BookMapperCustom bookMapperCustom;

    @Test
    public void test2() {
        BookQueryVo bookQueryVo = new BookQueryVo();
        List<BookCustom> list = new LinkedList<>();

        BookCustom bookCustom1 = new BookCustom();
        long l1 = 1000;
        bookCustom1.setBookid(l1);
        BookCustom bookCustom2 = new BookCustom();
        long l2 = 1001;
        bookCustom2.setBookid(l2);
        BookCustom bookCustom3 = new BookCustom();
        long l3 = 1002;
        bookCustom3.setBookid(l3);
        BookCustom bookCustom4 = new BookCustom();
        long l4 = 1003;
        bookCustom4.setBookid(l4);

        list.add(bookCustom1);
        list.add(bookCustom2);
        list.add(bookCustom3);
        list.add(bookCustom4);

        bookQueryVo.setBookList(list);
        try {
            List<BookCustom> booklist = bookMapperCustom.findBookList(null);
            for(Book book:booklist){
                System.out.println(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
