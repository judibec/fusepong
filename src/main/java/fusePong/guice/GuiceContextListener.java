package fusePong.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fusePong.persistence.*;
import fusePong.persistence.mybatis.*;
import fusePong.login.LoginServices;
import fusePong.login.LoginServicesImpl;
import fusePong.services.TicketsServices;
import fusePong.services.UserServices;
import fusePong.services.impl.TicketsServicesImpl;
import fusePong.services.impl.UserServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener{
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");


                //Services
                bind(TicketsServices.class).to(TicketsServicesImpl.class);
                bind(LoginServices.class).to(LoginServicesImpl.class);
                bind(UserServices.class).to(UserServicesImpl.class);


                //DAO
                bind(CompanyDAO.class).to(MyBatisCompanyDAO.class);
                bind(ProjectDAO.class).to(MyBatisProjectDAO.class);
                bind(StoriesDAO.class).to(MyBatisStoriesDAO.class);
                bind(TicketsDAO.class).to(MyBatisTicketsDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }
}
