package com.example.multidata.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.example.multidata.mappers.oracle", sqlSessionTemplateRef = "oracleSqlSessionTemplate")
public class OracleConfig {

    //将这个对象放入Spring容器中
    @Bean(name = "oracleDataSource")
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource getSqlserverDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleSqlSessionFactory")
    //@Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        return bean.getObject();
    }

    @Bean("oracleSqlSessionTemplate")
    public SqlSessionTemplate test1sqlsessiontemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}
