package com.adesso.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.db.Db;
import com.adesso.insurance.entity.Person;

public class PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);


    public static void addPerson(Person person) throws ParseException {

        String query = "INSERT INTO person (id, lastname,firstname,gender,city,street,postalcode,birthdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getLastname());
            stmt.setString(3, person.getFirstname());
            stmt.setString(4, person.getGender());
            stmt.setString(5, person.getCity());
            stmt.setString(6, person.getStreet());
            stmt.setInt(7, person.getPostalcode());
            stmt.setString(8, person.getBirthDate());

			if (checkPersonInTheList(person)) {
				stmt.executeUpdate();
				LOGGER.info("PERSON ADDED IN THE LIST : " + person.toString());
			} else {
				LOGGER.warn("PERSON ALREADY EXIST IN THE LIST : " + person.toString());
			}

		} catch (Exception e) {
            LOGGER.error("" + e.getMessage());
		}
	}

	
    public static Person getPerson(int id) throws ParseException {
		Person person = null;
        String query = "SELECT * FROM person WHERE id = ?;";
        try (Connection conn = Db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("gender"),
						rs.getString("city"), rs.getString("street"), rs.getInt("postalcode"),
						rs.getString("birthdate"));
            }
            conn.close();
		} catch (SQLException e) {
            LOGGER.error("" + e.getMessage());
		}
		return person;
	}

	public static List<Person> getAllPersons() throws ParseException {
		List<Person> persons = new ArrayList<>();
		String query = "SELECT * FROM person";
        try (Connection conn = Db.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
                Person person = new Person(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("gender"),
						rs.getString("city"), rs.getString("street"), rs.getInt("postalcode"),
						rs.getString("birthdate"));

				persons.add(person);
			}
            conn.close();
		} catch (SQLException e) {
            LOGGER.error("" + e.getMessage());
		}
		return persons;
	}

    public static void updatePersonByFirstName(String firstname, Person updatedPerson) {
        String query =
                "UPDATE person SET id = ?, lastname = ?, firstname = ?, gender = ?, city = ?, street = ?, postalcode = ?, birthdate = ? WHERE firstname = ?";
        try (Connection conn = Db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, updatedPerson.getId());
            stmt.setString(2, updatedPerson.getLastname());
            stmt.setString(3, updatedPerson.getFirstname());
            stmt.setString(4, updatedPerson.getGender());
            stmt.setString(5, updatedPerson.getCity());
            stmt.setString(6, updatedPerson.getStreet());
            stmt.setInt(7, updatedPerson.getPostalcode());
            stmt.setString(8, updatedPerson.getBirthDate());
            stmt.setString(9, firstname);

			stmt.executeUpdate();

            conn.close();
		} catch (SQLException e) {
            LOGGER.error("" + e.getMessage());
		}
	}

    public static void deletePerson(int id) {
		String query = "DELETE FROM person WHERE firstname = ?";
        try (Connection conn = Db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            Person persToDeleted = getPerson(id);
			
			LOGGER.info("PERSON WOULD BE DELETED : "+persToDeleted.toString());
			stmt.executeUpdate();
			LOGGER.info("PERSON HAS BEEN DELETED");
            conn.close();
		} catch (SQLException | ParseException e) {
            LOGGER.error("" + e.getMessage());
		}
	}
	

    private static boolean checkPersonInTheList(Person pers) throws ParseException {
		
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
