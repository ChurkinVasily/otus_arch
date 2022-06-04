package ru.churkin.hometeco.dockstart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration()
class DockstartApplicationTest {

//    @Test
//    public void testDatabaseConnection() throws IOException {
//        Properties properties = new Properties();
//
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
////        InputStream stream = loader.getResourceAsStream("/src/main/resources/application.yml");
//        InputStream stream = loader.getResourceAsStream("C:\\Users\\Василий\\IdeaProjects\\dockstart\\src\\main\\resources\\application.yml");
//        properties.load(stream);
//
//        String url = properties.getProperty("spring.datasource.url");
//        String username = properties.getProperty("spring.datasource.username");
//        String password = properties.getProperty("spring.datasource.password");


//        String jdbcUrl = "jdbc:postgresql://postgresql.db.server:5430/my_database?ssl=true&loglevel=2";
//        String username = "dbUser";
//        String password = "1234567";
//        try (Connection conn = DriverManager.getConnection(url, username, password)) {
//            assertNotNull(conn);
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        }
//    }

}