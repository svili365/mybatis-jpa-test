package com.littlenb.mybatisjpa.demo.foo;


import com.littlenb.mybatisjpa.keygen.IdentityKeyGenerator;
import com.littlenb.mybatisjpa.statement.AnnotationStatementRegistry;
import com.littlenb.mybatisjpa.support.AnnotationStatementScanner;
import com.littlenb.mybatisjpa.support.Constant;
import javax.annotation.PostConstruct;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sway.li
 **/
@Component
public class AnnotationStatementInit {

  @Autowired
  private SqlSessionFactory sqlSessionFactory;

  @PostConstruct
  public void init() {
    Configuration configuration = sqlSessionFactory.getConfiguration();
    KeyGenerator keyGenerator = new IdentityKeyGenerator(new MyIdGenerator());
    configuration.addKeyGenerator(Constant.DEFAULT_KEY_GENERATOR, keyGenerator);
    AnnotationStatementScanner annotationStatementScanner = new AnnotationStatementScanner.Builder()
        .configuration(configuration)
        .basePackages(new String[]{"com.littlenb.persistence.demo.mapper"})
        .annotationStatementRegistry(AnnotationStatementRegistry.getDefaultRegistry()).build();
    annotationStatementScanner.scan();
  }
}
