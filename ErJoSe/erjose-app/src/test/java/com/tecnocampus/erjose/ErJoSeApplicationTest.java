package com.tecnocampus.erjose;

import com.tecnocampus.erjose.application.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ErJoSeApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseService;

	ObjectMapper objectMapper;

	@Test
	public void testCreateCourse() throws Exception {
		/*CourseDTO courseDTO = new CourseDTO("title", "description", "imageUrl");
		mockMvc.perform(post("/courses")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(courseDTO)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		verify(courseService, times(1)).createCourse(any(CourseDTO.class));*/
	}

	@Test
	public void testGetCourses() throws Exception {
		mockMvc.perform(get("/courses"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}