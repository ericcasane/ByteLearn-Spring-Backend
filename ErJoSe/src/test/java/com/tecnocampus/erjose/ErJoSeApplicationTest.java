package com.tecnocampus.erjose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnocampus.erjose.api.CourseRestController;
import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CourseRepository;
import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
@ActiveProfiles("test")
public class ErJoSeApplicationTest {

	private Connection connection;
	private CourseDTO courseDTO;

	@BeforeAll
	public void setUpBefore() throws SQLException {
		//courseDTO = new CourseDTO();
		emptyTables();
	}
	private void emptyTables() throws SQLException {
		connection = getConnection();

		connection.prepareStatement("DELETE FROM courses").execute();
	}
	private void initMasterData() throws SQLException {

	}
	private Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1/ErJoSe?createDatabaseIfNotExist=true&serverTimezone=UTC";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}
}
