package cn.jims.dao;

import cn.jims.entity.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Long bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long bookid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}