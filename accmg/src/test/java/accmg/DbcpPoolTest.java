package accmg;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
            locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
        )
@TestMethodOrder(OrderAnnotation.class)
public class DbcpPoolTest {
    
    @Autowired
    @Qualifier("hikariConfig")
    private HikariConfig config;
    
    @Autowired
    private HikariDataSource ds;
    
    @Autowired
    private SqlSessionFactoryBean sessionFactory;
    
    @Test
    public void testSqlSession() {
        
        Assertions.assertNotNull(sessionFactory);
        log.info("session", sessionFactory);
        
    }
    
    @Test
    @Order(1)
    public void testDataSource() throws Exception {
        
        Assertions.assertNotNull(config);
        log.info("config = {}",config);
        
        Assertions.assertNotNull(ds);
        log.info("ds={}",ds);
        
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn);
        log.info("conn={}",conn);
        
        conn.close();
        log.info("conn close 성공");
//        
        
    }
    
}
