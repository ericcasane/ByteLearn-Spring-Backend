package com.tecnocampus.erjose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnocampus.erjose.api.CourseRestController;
import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.persistence.CourseRepository;
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

@SpringBootTest
@ActiveProfiles("test")
public class ErJoSeApplicationTest {

	@Autowired
	private CourseRestController courseRestController;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;

	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();
	}

	@Test
	void testHappyPath() throws Exception {

		CourseDTO courseDTO = new CourseDTO("New Course", "Description", "image-url");
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(courseDTO))
				)
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	void testErrorHandling() throws Exception {


		Course invalidCourse = new Course();
		invalidCourse.setTitle(null);
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(invalidCourse))
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	void testListCoursesByTitleOrDescription() throws Exception {

		CourseDTO course1 = new CourseDTO("Java Basics", "Learn the basics of Java programming", "java-basics.jpg");
		CourseDTO course2 = new CourseDTO("Python Fundamentals", "Fundamental concepts of Python programming", "python-fundamentals.jpg");
		CourseDTO course3 = new CourseDTO("Data Science", "Introduction to data science with Python", "data-science.jpg");
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course1))
				)
				.andExpect(MockMvcResultMatchers.status().isCreated());

		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course2))
				)
				.andExpect(MockMvcResultMatchers.status().isCreated());

		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course3))
				)
				.andExpect(MockMvcResultMatchers.status().isCreated());


		mockMvc.perform(MockMvcRequestBuilders
						.get("/courses?query=Java")
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Java Basics"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Learn the basics of Java programming"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Python Fundamentals"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Fundamental concepts of Python programming"));
	}

	@Test
	void testNonexistentCourseUpdate() throws Exception {
		CourseDTO updates = new CourseDTO("New Title", "New Description", "new-image.jpg");
		mockMvc.perform(MockMvcRequestBuilders
						.patch("/courses/1000")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updates))
				)
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testDuplicateCourseTitle() throws Exception {
		CourseDTO course1 = new CourseDTO("Unique Title", "Description 1", "image1.jpg");
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course1))
				)
				.andExpect(MockMvcResultMatchers.status().isCreated());

		CourseDTO course2 = new CourseDTO("Unique Title", "Description 2", "image2.jpg");
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course2))
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}


	@Test
	void testTitleWithLowercaseInitialLetter() throws Exception {
		CourseDTO course = new CourseDTO("java Programming", "Description", "image.jpg");
		mockMvc.perform(MockMvcRequestBuilders
						.post("/courses")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(course))
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
