package cn.jims.service.impl;

import cn.jims.dao.BookMapper;
import cn.jims.dao.cache.RedisDao;
import cn.jims.entity.Book;
import cn.jims.entity.BookCustom;
import cn.jims.exception.CustomException;
import cn.jims.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jims on 2017/2/7.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RedisDao redisDao;

    @Override
    public Book selectByPrimaryKey(Long bookId) throws CustomException {

        if (bookId == null) {
            throw new CustomException("你要查询的图书不存在！");
        }
        // 缓存优化
        Book book = redisDao.getBook(bookId);
        if (book == null) {
            // 缓存中未获取到，从数据库获取，并缓存到Redis
            book = bookMapper.selectByPrimaryKey(bookId);
            redisDao.putBook(book);
        }
        return book;
    }

    @Override
    public int updateByPrimaryKey(long bookId, Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

}
