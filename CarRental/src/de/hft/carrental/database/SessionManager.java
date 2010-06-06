package de.hft.carrental.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import de.hft.carrental.domain.Agency;
import de.hft.carrental.domain.Booking;
import de.hft.carrental.domain.Branch;
import de.hft.carrental.domain.BranchAddress;
import de.hft.carrental.domain.Car;
import de.hft.carrental.domain.CarType;
import de.hft.carrental.domain.Customer;
import de.hft.carrental.domain.CustomerAddress;

/**
 * The session manager is a singleton that enables clients to retrieve sessions
 * from everywhere in the code.
 * 
 * @author Alexander Weickmann
 */
public final class SessionManager {

	private static final SessionManager instance = new SessionManager();

	private AnnotationConfiguration configuration;

	private final SessionFactory sessionFactory;

	private Session session;

	private SessionManager() {
		// TODO Read annotation configuration from external config file.
		configuration = new AnnotationConfiguration();
		configuration = configuration.addAnnotatedClass(Agency.class);
		configuration = configuration.addAnnotatedClass(Booking.class);
		configuration = configuration.addAnnotatedClass(Branch.class);
		configuration = configuration.addAnnotatedClass(BranchAddress.class);
		configuration = configuration.addAnnotatedClass(Car.class);
		configuration = configuration.addAnnotatedClass(CarType.class);
		configuration = configuration.addAnnotatedClass(Customer.class);
		configuration = configuration.addAnnotatedClass(CustomerAddress.class);

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
