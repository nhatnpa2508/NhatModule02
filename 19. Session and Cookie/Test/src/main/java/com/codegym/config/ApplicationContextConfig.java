/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/24/2019                     *
 * Time: 8:42 AM                     *
 *************************************
 */

package com.codegym.config;

import com.codegym.dao.impl.AccountDAOImpl;
import com.codegym.dao.impl.OrderDAOImpl;
import com.codegym.dao.impl.ProductDAOImpl;
import org.hibernate.SessionFactory;
import com.codegym.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.codegym")
@EnableTransactionManagement
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {

    //Lưu trữ các giá trị thuộc tính load bởi @PropertySource
    @Autowired
    private Environment env;

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        //Load property in message/validator.properties
        rb.setBasenames(new String[]{"messages/validator"});
        return rb;
    }

    @Bean(name="viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //Cấu hình để upload
    @Bean(name = "mutipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        //Set Max Size..
        //commonsMultipartResolver.setMaxUploadSize();
        return commonsMultipartResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Xem: ds-hibernate-cfg.properties
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shop");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        System.out.println("## getDataSource: " + dataSource);
        return dataSource;
    }
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception{
        Properties properties = new Properties();

        // Xem: ds-hibernate-cfg.properties
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("current_session_context_class", "thread");

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        //Pakage chứa các entity class;
        factoryBean.setPackagesToScan(new String[]{"com.codegym.entity"});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();

        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }

/*    @Bean(name = "accountDAO")
    public AccountDAO getApplicantDAO() {
        return new AccountDAOImpl();
    }*/

    @Bean(name = "productDAO")
    public ProductDAO getProductDAO() {
        return new ProductDAOImpl();
    }

    @Bean(name = "orderDAO")
    public OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }

    @Bean(name = "accountDAO")
    public AccountDAO getAccountDAO()  {
        return new AccountDAOImpl();
    }


}
