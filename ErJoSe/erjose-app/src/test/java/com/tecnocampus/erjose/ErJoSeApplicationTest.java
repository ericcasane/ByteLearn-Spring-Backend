package com.tecnocampus.erjose;

import com.fasterxml.jackson.databind.JsonNode;
import com.tecnocampus.erjose.application.CourseService;
import com.tecnocampus.erjose.application.dto.CategoryDTO;
import com.tecnocampus.erjose.application.dto.CourseDetailsDTO;
import com.tecnocampus.erjose.application.dto.LanguageDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ErJoSeApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CourseService courseService;

	String course;
	String category;
	String language;

	@Test
	void getAllCourses() throws Exception {
		mockMvc.perform(get("/courses"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$").isArray())
				.andDo(MockMvcResultHandlers.print());
	}

	@WithMockUser(roles = {"ADMIN", "TEACHER"}, authorities = {"CREATE_COURSE"})
	@Test
	void testCreateCourse() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/courses")
				.contentType("application/json")
				.content("""
       				{
						"title": "Test Course",
						"description": "Test Course Description",
						"imageUrl": "https://www.test.com/test.jpg"
					}
				"""))
				.andExpect(status().isCreated())
				.andReturn();

		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		JsonNode responseJson = objectMapper.readTree(actualResponseBody);
		String createdCategoryId = responseJson.get("id").textValue();
	}

	@WithMockUser(roles = {"ADMIN", "TEACHER"}, authorities = {"CREATE_CATEGORY"})
	@Test
	void testCreateCategory() throws Exception {
		CategoryDTO expectedCategory = new CategoryDTO("Test Category", "Test Category Description");
		MvcResult mvcResult = mockMvc.perform(post("/categories")
				.contentType("application/json")
				.content("""
	   				{
						"name": "Test Category",
						"description": "Test Category Description"
					}
				"""))
				.andExpect(status().isCreated())
				.andReturn();

		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		assertEquals(actualResponseBody, objectMapper.writeValueAsString(expectedCategory));
	}

	@WithMockUser(authorities = {"UPDATE_COURSE"})
	@Test
	void testAddCategoryToCourse() throws Exception {
		mockMvc.perform(post("/courses/{courseId}/categories", course))
				.andExpect(status().isOk());
	}

	@WithMockUser(roles = {"ADMIN"})
	@Test
	void testCreateLanguage() throws Exception {
		LanguageDTO expectedLanguage = new LanguageDTO("Test Language", "ts_TS", false);
		MvcResult mvcResult = mockMvc.perform(post("/languages")
				.contentType("application/json")
				.content("""
	   				{
					  "name": "Test Language",
					  "locale": "ts_TS",
					  "defaultLanguage": false
					}
				"""))
				.andExpect(status().isCreated())
				.andReturn();

		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		assertEquals(actualResponseBody, objectMapper.writeValueAsString(expectedLanguage));
	}

	@WithMockUser(roles = {"ADMIN"})
	@Test
	void testCreateLanguageWithErrors() throws Exception {
		mockMvc.perform(post("/languages")
				.contentType("application/json")
				.content("""
	   				{
					  "name": "test language",
					  "locale": "TS_ts",
					  "defaultLanguage": false
					}
				"""))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.violations[*].fieldName", containsInAnyOrder("name", "locale")))
				.andExpect(jsonPath("$.violations[*].message", containsInAnyOrder(
						"Name must begin with a capital letter",
						"Locale must be in the format ll_CC")));
	}
}