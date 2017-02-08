package test.cache;

import cn.jims.dao.BookMapper;
import cn.jims.dao.cache.RedisDao;
import cn.jims.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SHENG on 2016/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class RedisDaoTest {

    private long id = 1001;
    @Autowired
    private RedisDao redisDao;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void getSeckill() throws Exception {
        // get and put
        Book book = redisDao.getBook(id);
        if (book == null) {
            book = bookMapper.selectByPrimaryKey(id);
            if (book != null) {
                String result = redisDao.putBook(book);
                System.out.println(result);
                book = redisDao.getBook(id);
                System.out.println(book);
            }
        } else {
            System.out.println(book);
        }
    }


}