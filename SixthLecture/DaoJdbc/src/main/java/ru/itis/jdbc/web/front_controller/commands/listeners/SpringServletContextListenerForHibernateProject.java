package ru.itis.jdbc.web.front_controller.commands.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SpringServletContextListenerForHibernateProject implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml", "spring/db-context.xml");
        sce.getServletContext().setAttribute("hibernateSpringContext", applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
