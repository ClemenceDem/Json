package com.adesso.insurance.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDAO {

	private final String url = "jdbc:mysql://localhost:3306/ais";
	private final String user = "root";
	private final String password = "Lizinaya29102022?";
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
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

	// Read
	public Person getPerson(String firstname) throws ParseException {
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

	public List<Person> getAllPersons() throws ParseException {
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
	

	public Boolean checkPersonInTheList(Person pers) throws ParseException {
		
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
