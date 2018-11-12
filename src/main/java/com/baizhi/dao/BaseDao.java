package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    //添加方法
    void insert(T t);
    //修改方法
    void update(T t);
    void updatecount(@Param("set_count") int set_count,@Param("id") String id);
    //删除方法
    void delete(String id);
    //批量删除方法
    void deleteAll(@Param("byid") String[] byid);
    //查询单个方法
    T queryOne(T t);
    T querypwd(String ypassword);
    T findOne(String id);
    //查询所有方法
    List<T> queryAll();
    /*查询分页
        参数1:起始条数 start   参数2:每页显示的记录数*/
    List<T> queryByPage(@Param("start") Integer start ,@Param("rows") Integer rows);
    //查询总页数 Totals
    Long queryTotals();
}


