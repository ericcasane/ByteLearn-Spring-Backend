package com.tecnocampus.erjose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.persistence.CourseRepository;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ErJoSeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CourseRepository courseRepository;
	@MockBean
	private CourseService courseService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@Order(4)
	public void checkDataRetrieval() {
		List<Map<String, Object>> courses = jdbcTemplate.queryForList("SELECT * FROM courses");
		for (Map<String, Object> course : courses) {
			for (Map.Entry<String, Object> entry : course.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			System.out.println("-----------");
		}
	}


	public void insertCourse() {
		String sql = "INSERT INTO courses (id, title, description, creation_date, last_update_date, image_url, current_price, available) " +
				"VALUES ('fecfd4a6-53e9-4a2e-bcd3-7a8d40773498', 'AAAIntroduction to Python Programming', 'Learn the fundamentals of Python programming language.', current_date, current_date, '/images/python.jpg', 49.99, true)";

		jdbcTemplate.execute(sql);
		checkDataRetrieval();
	}

	@Test
	@Order(3)
	public void testGetCourses2() throws Exception {
		insertCourse();
		MvcResult mvcResult = mockMvc.perform(get("/courses"))
				.andExpect(status().isOk())
				.andReturn();

		// Obtener la respuesta en forma de String
		String jsonResponse = mvcResult.getResponse().getContentAsString();

		// Imprimir el JSON recibido en la consola
		System.out.println("JSON response: " + jsonResponse);
	}

	@Test
	@Order(2)
	void testCreateCourse() throws Exception {
		JSONObject course = new JSONObject();
		course.put("title", "New Course");
		course.put("description", "A new course for testing");
		course.put("imageUrl", "example.jpg");

		JSONObject expectedResponse = new JSONObject();
		expectedResponse.put("title", "New Course");
		expectedResponse.put("description", "A new course for testing");
		expectedResponse.put("imageUrl", "example.jpg");
		expectedResponse.put("publicationDate", LocalDate.now().toString());
		expectedResponse.put("lastUpdateDate", LocalDate.now().toString());
		expectedResponse.put("currentPrice", 0);
		expectedResponse.put("available", false);

		mockMvc.perform(post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(course.toString()))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResponse.toString()));
	}

	@Test
	@Order(1)
	public void testGetCourses() throws Exception {
		Mockito.when(courseService.getCoursesAvailable()).thenReturn(List.of(
				new CourseDTO("Curso 1", "Descripción del Curso 1", "https://www.example.com/images/curso1.jpg"),
				new CourseDTO("Curso 2", "Descripción del Curso 2", "https://www.example.com/images/curso2.jpg")
		));

		mockMvc.perform(get("/courses"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("Curso 1"))
				.andExpect(jsonPath("$[0].description").value("Descripción del Curso 1"))
				.andExpect(jsonPath("$[1].title").value("Curso 2"))
				.andExpect(jsonPath("$[1].description").value("Descripción del Curso 2"));
	}

	@Test
	public void testGetCourses1() throws Exception {
		mockMvc.perform(get("/courses"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(3)))				;
	}

	@Test
	void testGetSearchCourses() throws Exception {
		mockMvc.perform(get("/courses")
						.param("search", "java"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].title").value("Full-Stack Web Development with Spring Boot 3 & React"))
				.andExpect(jsonPath("$[0].description").value("Build full-stack web applications using Java, Spring Boot 3, Spring Data JPA, Spring Security, JWT, JavaScript, React JS & MySQL."))
				.andExpect(jsonPath("$[1].title").value("Java Programming for Beginners"))
				.andExpect(jsonPath("$[1].description").value("Get started with Java programming from scratch."))
				;
	}*/



	/*@Test
	public void testUpdateCourse() throws Exception {
		Long courseId = 1L;
		Map<String, String> updates = new HashMap<>();
		updates.put("title", "Nuevo Título");

		Course updatedCourse = new Course();
		updatedCourse.setId(courseId);
		updatedCourse.setTitle("Nuevo Título");
		Mockito.when(courseService.updateCourseTitleDescrOrImageURL(courseId, updates))
				.thenReturn(new CourseDTO(updatedCourse));

		mockMvc.perform(MockMvcRequestBuilders.patch("/courses/{courseId}", courseId)
						.content(new ObjectMapper().writeValueAsString(updates))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("title").value("Nuevo Título"));
	}

	@Test
	public void testUpdateCoursePrice() throws Exception {
		Long courseId = 1L;
		BigDecimal newPrice = new BigDecimal("99.99");

		Course updatedCourse = new Course();
		updatedCourse.setId(courseId);
		updatedCourse.setCurrentPrice(newPrice);
		Mockito.when(courseService.updatePrice(courseId, newPrice))
				.thenReturn(new CourseDTO(updatedCourse));

		mockMvc.perform(MockMvcRequestBuilders.patch("/courses/{courseId}/price", courseId)
						.content(new ObjectMapper().writeValueAsString(new CourseDTO(null, null, null, newPrice, false)))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("currentPrice").value("99.99"));
	}

	@Test
	public void testUpdateCourseAvailable() throws Exception {
		Long courseId = 1L;
		boolean newAvailability = true;

		Course updatedCourse = new Course();
		updatedCourse.setId(courseId);
		updatedCourse.setAvailable(newAvailability);
		Mockito.when(courseService.updateAvailable(courseId, newAvailability))
				.thenReturn(new CourseDTO(updatedCourse));

		mockMvc.perform(MockMvcRequestBuilders.patch("/courses/{courseId}/available", courseId)
						.content(new ObjectMapper().writeValueAsString(new CourseDTO(null, null, null, null, newAvailability)))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("available").value("true"));
	}

	@Test
	public void testSearchCourses() throws Exception {
		String searchQuery = "java";
		List<CourseDTO> foundCourses = List.of(
				new CourseDTO("Java Programming", "Learn Java programming basics"),
				new CourseDTO("Advanced Java", "Advanced topics in Java programming")
		);

		Mockito.when(courseService.getCoursesByTitleOrDescription(searchQuery))
				.thenReturn(foundCourses);

		mockMvc.perform(get("/courses/search")
						.param("search", searchQuery))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("Java Programming"))
				.andExpect(jsonPath("$[0].description").value("Learn Java programming basics"))
				.andExpect(jsonPath("$[1].title").value("Advanced Java"))
				.andExpect(jsonPath("$[1].description").value("Advanced topics in Java programming"));
	}

	@Test
	public void testGetCoursesWhenError() throws Exception {
		// Simula una excepcion
		Mockito.when(courseService.getCoursesAvailable()).thenThrow(new RuntimeException("Error en el servicio"));

		mockMvc.perform(get("/courses"))
				.andExpect(status().isInternalServerError()); // Verif error HTTP 500
	}*/

}