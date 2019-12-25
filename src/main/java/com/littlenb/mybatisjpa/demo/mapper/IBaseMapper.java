package com.littlenb.mybatisjpa.demo.mapper;


import com.littlenb.mybatisjpa.annotation.InsertDefinition;
import com.littlenb.mybatisjpa.annotation.UpdateDefinition;
import com.littlenb.mybatisjpa.support.Certainty;
import com.littlenb.mybatisjpa.type.SelectorStrategy;
import java.util.List;

/**
 * @author sway.li
 **/
public interface IBaseMapper<T> {

  @InsertDefinition
  int insertBatch(List<T> t);

  @InsertDefinition
  int insert(T t);

  @InsertDefinition(strategy = SelectorStrategy.IGNORE_NULL)
  int insertIgnoreNull(T t);

  @InsertDefinition(strategy = SelectorStrategy.CERTAIN)
  int insertCertain(Certainty<T> certainty);

  @UpdateDefinition
  int updateById(T t);

  @UpdateDefinition(strategy = SelectorStrategy.IGNORE_NULL)
  int updateByIdIgnoreNull(T t);

  @UpdateDefinition(strategy = SelectorStrategy.CERTAIN, where = " id = #{entity.id}")
  int updateByIdCertain(Certainty<T> certainty);

}
