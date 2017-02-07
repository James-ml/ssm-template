package cn.jims.service.impl;

import cn.jims.dao.BookMapper;
import cn.jims.entity.Book;
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

    @Override
    public Book selectByPrimaryKey(Long bookId) throws CustomException {

        if (bookId >1003||bookId<1000) {
            throw new CustomException("你要查询的图书不存在！");
        }
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKey(long bookId, Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

}
