package com.littlenb.mybatisjpa.demo.mapper;

import com.littlenb.mybatisjpa.demo.model.UserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author sway.li
 **/
@Mapper
@Repository
public interface UserRoleRelationMapper extends IBaseMapper<UserRoleRelation> {

}
