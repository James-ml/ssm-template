package cn.jims.service;

import cn.jims.entity.Book;
import cn.jims.exception.CustomException;

/**
 * Created by Jims on 2017/2/7.
 */
public interface BookService {

    Book selectByPrimaryKey(Long bookId) throws CustomException;

    int updateByPrimaryKey(long bookId,Book record);
}
