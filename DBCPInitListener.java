package com.ja.board.listener;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.*;
import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Application Lifecycle Listener implementation class DBCPInitListener
 *
 */

public class DBCPInitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBCPInitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	//DBCP 세팅 코드...
    	
    	String jdbcUrl = arg0.getServletContext().getInitParameter("jdbcUrl");
    	String username = arg0.getServletContext().getInitParameter("dbUser");
    	String pw = arg0.getServletContext().getInitParameter("dbPassword");
    	
    	System.out.println("DBCP 가동 시작 : ");
    	System.out.println("url : "+jdbcUrl);
    	System.out.println("user : "+username);
    	System.out.println("pw : "+pw);
    	
    	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			

			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);

			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("oracleDBCP", connectionPool);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
}
