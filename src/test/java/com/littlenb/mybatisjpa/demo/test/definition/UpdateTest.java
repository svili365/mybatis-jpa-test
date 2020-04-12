package com.littlenb.mybatisjpa.demo.test.definition;

import com.littlenb.mybatisjpa.demo.mapper.UserMapper;
import com.littlenb.mybatisjpa.demo.model.User;
import com.littlenb.mybatisjpa.demo.test.AbstractTest;
import com.littlenb.mybatisjpa.demo.util.SerializeUtil;
import com.littlenb.mybatisjpa.support.Certainty;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sway.li
 **/
public class UpdateTest extends AbstractTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void update() {
    long id = 118299928123543553L;
    User user = new User();
    user.setId(id);
    user.setPassword("update password 123456");
    userMapper.updateById(user);
  }

  @Test
  public void updateIgnoreNull() {
    long id = 118299928123543553L;
    User user = new User();
    user.setId(id);
    user.setPassword("update password 123456");
    userMapper.updateByIdIgnoreNull(user);
  }

  @Test
  public void updateCertain() {
    long id = 118299928123543552L;
    User user = userMapper.selectById(id);
    user.setPassword("certain changed " + System.currentTimeMillis());
    user.setUniCode("certain changed " + System.currentTimeMillis());
    Set<String> includes = new HashSet<>();
    includes.add("uniCode");
    int i = userMapper.updateByIdCertain(Certainty.includes(user, includes));
    System.out.println(i);
    System.out.println(SerializeUtil.toJSONString(userMapper.selectById(id)));
  }

}
