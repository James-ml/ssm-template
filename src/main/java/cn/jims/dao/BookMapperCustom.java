package cn.jims.dao;

import cn.jims.entity.BookCustom;
import cn.jims.entity.BookQueryVo;

import java.util.List;

/**
 * Created by Jims on 2017/2/7.
 */
public interface BookMapperCustom {
    //图书查询列表
    List<BookCustom> findBookList(BookQueryVo bookQueryVo)throws Exception;
}
