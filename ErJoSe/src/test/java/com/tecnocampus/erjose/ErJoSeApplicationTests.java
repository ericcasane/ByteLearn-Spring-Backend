package com.tecnocampus.erjose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CourseDTO;
import com.tecnocampus.erjose.domain.Course;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ErJoSeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseService;

	@Test
	public void testGetCourses() throws Exception {
		Mockito.when(courseService.getCoursesAvailable()).thenReturn(List.of(
				new CourseDTO("Curso 1", "Descripción del Curso 1"),
				new CourseDTO("Curso 2", "Descripción del Curso 2")
		));

		mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("Curso 1"))
				.andExpect(jsonPath("$[0].description").value("Descripción del Curso 1"))
				.andExpect(jsonPath("$[1].title").value("Curso 2"))
				.andExpect(jsonPath("$[1].description").value("Descripción del Curso 2"));
	}

	@Test
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

		mockMvc.perform(MockMvcRequestBuilders.get("/courses/search")
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

		mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
				.andExpect(status().isInternalServerError()); // Verif error HTTP 500
	}

}