package com.littlenb.mybatisjpa.demo.test.plugin;

import com.alibaba.fastjson.JSON;
import com.littlenb.mybatisjpa.demo.model.User;
import com.littlenb.mybatisjpa.demo.mapper.UserMapper;
import com.littlenb.mybatisjpa.demo.test.AbstractTest;
import javax.annotation.Resource;
import org.junit.Test;

public class ResultTypeTest extends AbstractTest {

  @Resource
  private UserMapper userMapper;

  @Test
  public void selectById() {
    long id = 118299928123543552L;

    User user = userMapper.selectById(id);
    System.out.println(JSON.toJSONString(user));

    // select twice,watch the resultMap reload times.
    User user2 = userMapper.selectById(id);
    System.out.println(JSON.toJSONString(user2));
  }

  @Test
  public void selectOneToOne() {
    long id = 118299928123543552L;
    User user = userMapper.selectOneToOne(id);
    System.out.println(JSON.toJSONString(user));
  }

  @Test
  public void selectOneToMany() {
    long id = 118299928123543552L;
    User user = userMapper.selectOneToMany(id);
    System.out.println(JSON.toJSONString(user));
  }

  @Test
  public void selectUnion() {
    long id = 118299928123543552L;
    User user = userMapper.selectUnion(id);
    System.out.println(JSON.toJSONString(user));
  }

}
