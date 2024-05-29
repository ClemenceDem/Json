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
import java.util.Optional;

public class PersonDAO {

	private final String url = "jdbc:mysql://localhost:3306/ais";
	private final String user = "root";
	private final String password = "Lizinaya29102022?";

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

			try {
				if (ObjectIsInList(person)) {

				}
			} catch (Exception e) {

				e.printStackTrace();
			}

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Read
	public Optional<Person> getPerson(String firstname) throws ParseException {
		String query = "SELECT * FROM person WHERE firstname = ?;";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, firstname);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Person person = new Person(rs.getString("lastname"), rs.getString("firstname"), rs.getString("gender"),
						rs.getString("city"), rs.getString("street"), rs.getInt("postalcode"),
						rs.getString("birthdate"));

				return Optional.of(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
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
			e.printStackTrace();
		}
		return persons;
	}

	public void updatePerson(Person updatedPerson) {
		String query = "UPDATE person SET lastname = Demanou, firstname = Clemence, gender = female, city = Braunschweig, street = Gleiwitzstrasse, postacode = 38124, birthdate = 1995-02-01)";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, updatedPerson.getLastname());
			stmt.setString(2, updatedPerson.getFirstname());
			stmt.setString(3, updatedPerson.getGender());
			stmt.setString(4, updatedPerson.getCity());
			stmt.setString(5, updatedPerson.getStreet());
			stmt.setInt(6, updatedPerson.getPostalcode());
			stmt.setString(7, updatedPerson.getBirthDate());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePerson(String firstname) {
		String query = "DELETE FROM person WHERE firstname = ?;";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, firstname);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean ObjectIsInList(Person pers) throws ParseException {
		if (getAllPersons().size() <= 0) {
			addPerson(pers);
		} else {
			for (Person actualPerson : getAllPersons()) {
				if (actualPerson.compareTo(pers)) {
					return false;
				} else {
					return true;
				}
			}

		}

		return false;
	}

}
