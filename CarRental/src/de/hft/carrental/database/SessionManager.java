package de.hft.carrental.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * The session manager is a singleton that enables clients to retrieve sessions
 * from everywhere in the code.
 * 
 * @author Alexander Weickmann
 */
public final class SessionManager {

	private static final SessionManager instance = new SessionManager();

	private final AnnotationConfiguration configuration;

	private final SessionFactory sessionFactory;

	private Session session;

	private SessionManager() {
		configuration = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		openSession();
	}

	public static SessionManager getInstance() {
		return instance;
	}

	public Session openSession() {
		if (session == null) {
			if (!(isDatabaseConnectionAvailable())) {
				return null;
			}
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void dispose() {
		sessionFactory.close();
	}

	private boolean isDatabaseConnectionAvailable() {
		String url = configuration.getProperty("hibernate.connection.url");
		String dbuser = configuration
				.getProperty("hibernate.connection.username");
		String dbpassword = configuration
				.getProperty("hibernate.connection.password");
		try {
			Connection connection = DriverManager.getConnection(url, dbuser,
					dbpassword);
			return (connection == null) ? false : true;
		} catch (SQLException e) {
			return false;
		}
	}

}
