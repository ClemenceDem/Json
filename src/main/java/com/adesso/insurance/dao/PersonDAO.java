package com.adesso.insurance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.config.ConfigLoader;

public class PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);
    /*
     * private final static String URL = "jdbc:mysql://localhost:3306/ais"; private final static String USER = "root"; private final static String
     * PASSWORD = "Lizinaya29102022?";
     */
    private static EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.URL", ConfigLoader.getProperty("jdbc:mysql://localhost:3306/ais"));
        properties.put("javax.persistence.jdbc.USER", ConfigLoader.getProperty("root"));
        properties.put("javax.persistence.jdbc.PASSWORD", ConfigLoader.getProperty("Lizinaya29102022?"));

        entityManagerFactory = Persistence.createEntityManagerFactory("persistence", properties);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static Connection getConnection() throws SQLException {

        String key = null;
        return DriverManager.getConnection(ConfigLoader.getProperty(key));
    }



	public void addPerson(Person person) throws ParseException {

		String query = "INSERT INTO person (lastname,firstname,gender,city,street,postalcode,birthdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, person.getLastname());
			stmt.setString(2, person.getFirstname());
			stmt.setString(3, person.getGender());
			stmt.setString(4, person.getCity());
			stmt.setString(5, person.getStreet());
			stmt.setInt(6, person.getPostalcode());
			stmt.setString(7, person.getBirthDate());

			if (checkPersonInTheList(person)) {
				stmt.executeUpdate();
				LOGGER.info("PERSON ADDED IN THE LIST : " + person.toString());
			} else {
				LOGGER.warn("PERSON ALREADY EXIST IN THE LIST : " + person.toString());
			}

		} catch (Exception e) {
			LOGGER.error("MESSAGE : " + e.getMessage());
		}
	}

	
	public static Person getPerson(String firstname) throws ParseException {
		Person person = null;
		String query = "SELECT * FROM person WHERE firstname = ?;";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, firstname);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				person = new Person(rs.getString("lastname"), rs.getString("firstname"), rs.getString("gender"),
						rs.getString("city"), rs.getString("street"), rs.getInt("postalcode"),
						rs.getString("birthdate"));
			}		
		} catch (SQLException e) {
			LOGGER.error("MESSAGE : " + e.getMessage());
		}
		return person;
	}

	public static List<Person> getAllPersons() throws ParseException {
		List<Person> persons = new ArrayList<>();
		String query = "SELECT * FROM person";
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Person person = new Person(rs.getString("lastname"), rs.getString("firstname"), rs.getString("gender"),
						rs.getString("city"), rs.getString("street"), rs.getInt("postalcode"),
						rs.getString("birthdate"));

				persons.add(person);
			}
		} catch (SQLException e) {
			LOGGER.error("MESSAGE : " + e.getMessage());
		}
		return persons;
	}

	public void updatePersonByFirstName(String firstname, Person updatedPerson) {
		String query = "UPDATE person SET lastname = ?, firstname = ?, gender = ?, city = ?, street = ?, postalcode = ?, birthdate = ? WHERE firstname = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, updatedPerson.getLastname());
			stmt.setString(2, updatedPerson.getFirstname());
			stmt.setString(3, updatedPerson.getGender());
			stmt.setString(4, updatedPerson.getCity());
			stmt.setString(5, updatedPerson.getStreet());
			stmt.setInt(6, updatedPerson.getPostalcode());
			stmt.setString(7, updatedPerson.getBirthDate());
			stmt.setString(8, firstname);

			stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("MESSAGE : " + e.getMessage());
		}
	}

	public void deletePerson(String firstname) {
		String query = "DELETE FROM person WHERE firstname = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, firstname);
			Person persToDeleted = getPerson(firstname);
			
			LOGGER.info("PERSON WOULD BE DELETED : "+persToDeleted.toString());
			stmt.executeUpdate();
			LOGGER.info("PERSON HAS BEEN DELETED");
		} catch (SQLException | ParseException e) {
			LOGGER.error("MESSAGE : " + e.getMessage());
		}
	}
	

	private boolean checkPersonInTheList(Person pers) throws ParseException {
		
		if (getAllPersons().isEmpty()) {
			return true;
		}

		int count = 0;
		if (!getAllPersons().isEmpty()) {
			Boolean control = false;
			for (Person actualPerson : getAllPersons()) {
				if (actualPerson.compareTo(pers)) {
					return false;
				} else {
					control = true;
				}
				count++;
				if (getAllPersons().size() - count == 0) {
					return control;
				}
			}
		}
		return false;
	}

}
