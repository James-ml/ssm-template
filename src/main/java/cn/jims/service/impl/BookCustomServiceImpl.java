package cn.jims.service.impl;

import cn.jims.dao.BookMapperCustom;
import cn.jims.entity.BookCustom;
import cn.jims.entity.BookQueryVo;
import cn.jims.service.BookCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jims on 2017/2/7.
 */
@Service
public class BookCustomServiceImpl implements BookCustomService {

    @Autowired
    private BookMapperCustom bookMapperCustom;

    @Override
    public List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception {
        return bookMapperCustom.findBookList(bookQueryVo);
    }
}
