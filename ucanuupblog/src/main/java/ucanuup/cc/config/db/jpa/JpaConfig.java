package ucanuup.cc.config.db.jpa;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={"ucanuup.cc.blog.services.*.dao"}) //这个是你Repositorie所在的包
@EnableTransactionManagement //这个是事务
public class JpaConfig{


  /*  @Primary //springboot默认是多数据源，所以你要指定一个主数据源，不然会错误
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary") //需要导入配置
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }*/
    
    @Resource
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;

    @Primary //springboot默认是多数据源，所以你要指定一个主数据源，不然会错误
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);//这里指定的你数据库的类型
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ucanuup.cc.blog.services.*.entity");//这个是你entity所在的包
        factory.setDataSource(primaryDataSource);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}