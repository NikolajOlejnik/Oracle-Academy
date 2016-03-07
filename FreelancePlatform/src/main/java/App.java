import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.oracleacademy.fp.dao.jdbc.JdbcUserDao;
import ua.oracleacademy.fp.domain.users.Client;
import ua.oracleacademy.fp.domain.users.User;

import java.util.List;
import java.util.Set;

public class App {
    private static AbstractApplicationContext appContext;
    public static void main(String[] args) {

        appContext = new ClassPathXmlApplicationContext("appContext.xml");

        JdbcUserDao dao = (JdbcUserDao) appContext.getBean("userDao");

        System.out.println(dao.findUserByLogin("admin"));
    }
}
