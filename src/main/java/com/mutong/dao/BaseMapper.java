package com.mutong.dao;

public interface BaseMapper<T> {

  /**
   * 删除数据
   *
   * @mbggenerated 2019-12-17
   */
  int deleteByPrimaryKey(Long id);

  /**
   * 插入数据
   *
   * @mbggenerated 2019-12-17
   */
  int insert(T record);

  /**
   * 条件插入
   *
   * @mbggenerated 2019-12-17
   */
  int insertSelective(T record);

  /**
   * 主键查询
   *
   * @mbggenerated 2019-12-17
   */
  T selectByPrimaryKey(Long id);

  /**
   * 条件修改
   *
   * @mbggenerated 2019-12-17
   */
  int updateByPrimaryKeySelective(T record);

  /**
   * 修改数据
   *
   * @mbggenerated 2019-12-17
   */
  int updateByPrimaryKey(T record);
}
