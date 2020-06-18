package com.littlenb.mybatisjpa.demo.foo;


import com.littlenb.mybatisjpa.keygen.DefaultIdGenerator;
import com.littlenb.mybatisjpa.keygen.IdentityKeyGenerator;
import com.littlenb.mybatisjpa.statement.AnnotationStatementRegistry;
import com.littlenb.mybatisjpa.support.AnnotationStatementScanner;
import com.littlenb.mybatisjpa.support.Constant;
import com.littlenb.mybatisjpa.support.MybatisJapConfiguration;
import com.littlenb.mybatisjpa.util.NamingPolicy;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sway.li
 **/
@Configuration
public class MybatisJpaInitializer {

  @Bean
  public AnnotationStatementScanner annotationStatementScanner(SqlSessionFactory sqlSessionFactory) {
    // 全局配置
    MybatisJapConfiguration conf = MybatisJapConfiguration.getInstance();
    conf.setTableNamingStrategy(NamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    conf.setColumnNamingStrategy(NamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
    KeyGenerator keyGenerator = new IdentityKeyGenerator(DefaultIdGenerator.newInstance());
    configuration.addKeyGenerator(Constant.DEFAULT_KEY_GENERATOR, keyGenerator);
    // 自动构建SQL 扫描
    AnnotationStatementScanner annotationStatementScanner = new AnnotationStatementScanner.Builder()
            .configuration(configuration)
            .basePackages(new String[]{"com.littlenb.mybatisjpa.demo.mapper"})
            .annotationStatementRegistry(AnnotationStatementRegistry.getDefaultRegistry()).build();
    annotationStatementScanner.scan();
    return annotationStatementScanner;
  }

}
