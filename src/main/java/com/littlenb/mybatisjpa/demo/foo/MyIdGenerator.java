package com.littlenb.mybatisjpa.demo.foo;


import com.littlenb.mybatisjpa.keygen.IdGenerator;
import com.twitter.snowflake.support.SecondsIdGeneratorFactory;

/**
 * @author sway.li
 */
public class MyIdGenerator implements IdGenerator {

  private com.twitter.snowflake.sequence.IdGenerator idGenerator;

  public MyIdGenerator() {
    SecondsIdGeneratorFactory idGeneratorFactory = new SecondsIdGeneratorFactory(1483200000L);
    idGenerator = idGeneratorFactory.create(1L);
  }

  @Override
  public synchronized Object nextId() {
    return idGenerator.nextId();
  }

  @Override
  public synchronized Object[] nextSegment(int size) {
    long[] segment = idGenerator.nextSegment(size);
    Object[] array = new Object[size];
    for (int i = 0; i < size; i++) {
      array[i] = segment[i];
    }
    return array;
  }

}
