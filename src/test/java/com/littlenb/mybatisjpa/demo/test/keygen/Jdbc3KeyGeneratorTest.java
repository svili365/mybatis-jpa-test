package com.littlenb.mybatisjpa.demo.test.keygen;


import com.littlenb.mybatisjpa.demo.model.User;
import com.littlenb.mybatisjpa.demo.model.UserRoleRelation;
import com.littlenb.mybatisjpa.demo.mapper.UserMapper;
import com.littlenb.mybatisjpa.demo.mapper.UserRoleRelationMapper;
import com.littlenb.mybatisjpa.demo.test.AbstractTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sway.li
 **/
public class Jdbc3KeyGeneratorTest extends AbstractTest {

  @Autowired
  private UserRoleRelationMapper userRoleRelationMapper;

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testAuto(){
    UserRoleRelation entity = new UserRoleRelation();
    entity.setRoleId(1L);
    entity.setUserId(1L);
    userRoleRelationMapper.insert(entity);
    List<String> list = new ArrayList<>();
    // test mysql auto increment key
    System.out.println(entity.getId());
  }

  @Test
  public void testIdentity(){
    User user = new User();
    // user.setId(118299928123543557L);
    user.setUniCode(UUID.randomUUID().toString());
    user.setPassword("12345");
    userMapper.insertIgnoreNull(user);
    // test identity key
    System.out.println(user.getId());
  }

}
