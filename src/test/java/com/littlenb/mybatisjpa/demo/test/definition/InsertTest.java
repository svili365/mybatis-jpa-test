package com.littlenb.mybatisjpa.demo.test.definition;

import com.littlenb.mybatisjpa.demo.mapper.UserMapper;
import com.littlenb.mybatisjpa.demo.model.User;
import com.littlenb.mybatisjpa.demo.test.AbstractTest;
import com.littlenb.mybatisjpa.demo.util.SerializeUtil;
import com.littlenb.mybatisjpa.support.Certainty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sway.li
 **/
public class InsertTest extends AbstractTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void insert() {
    User user = new User();
    user.setPassword("12345");
    user.setUniCode(UUID.randomUUID().toString());
    userMapper.insert(user);
    System.out.println(user.getId());
  }

  @Test
  public void insertIgnoreNull() {
    User user = new User();
    user.setPassword("12345");
    user.setUniCode(UUID.randomUUID().toString());
    userMapper.insertIgnoreNull(user);
    System.out.println(user.getId());
  }

  @Test
  public void insertCertain() {
    User user = new User();
    user.setPassword("certain insert " + System.currentTimeMillis());
    user.setUniCode("certain insert " + System.currentTimeMillis());
    user.setGranted(false);
    user.setCreateTime(new Date());
    Set<String> includes = new HashSet<>();
    includes.add("id");
    includes.add("uniCode");
    includes.add("password");
    userMapper.insertCertain(Certainty.includes(user, includes));
    System.out.println(SerializeUtil.toJSONString(user));
  }

  @Test
  public void insertBatch() {
    List<User> list = new ArrayList<>();
    for(int i = 0;i<5;i++){
      User user = new User();
      user.setPassword("12345");
      user.setUniCode(UUID.randomUUID().toString());
      list.add(user);
    }
    int i = userMapper.insertBatch(list);
    System.out.println(i);
  }


}
