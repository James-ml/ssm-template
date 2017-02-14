package test.pagehelper;

import cn.jims.dao.BookMapperCustom;
import cn.jims.entity.BookCustom;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Jims on 2017/2/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class PageHelperTest {

    @Autowired
    private BookMapperCustom bookMapperCustom;

    @Test
    public void testPageHelper() {
        //创建一个spring容器
        //从spring容器中获得Mapper的代理对象

        //执行查询，并分页
        //BookExample example = new BookExample();
        //分页处理
        PageHelper.startPage(2, 10);//pageNum:代表第几页
        //List<Book> list = mapper.selectByExample(example);

        List<BookCustom> list = null;
        try {
            list = bookMapperCustom.findBookList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //取商品列表
        for (BookCustom book : list) {
            System.out.println(book.toString());
        }
        //取分页信息
        PageInfo<BookCustom> pageInfo = new PageInfo<BookCustom>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有图书："+ total);

    }
}
