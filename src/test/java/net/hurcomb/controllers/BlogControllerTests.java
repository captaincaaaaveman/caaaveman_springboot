package net.hurcomb.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BlogControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getBlogWithNoParametersShouldReturnFirstBlog() throws Exception {

		this.mockMvc.perform(get("/blog")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.markdown").value("# Database Blog"));
	}

	@Test
	public void allBlogsShouldReturnAList() throws Exception {

		this.mockMvc.perform(get("/allBlogs")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].markdown").value("# Database Blog"));
	}

//	@Test
//	public void paramGreetingShouldReturnTailoredMessage() throws Exception {
//
//		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
//		.andDo(print()).andExpect(status().isOk())
//		.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
//	}

	
}
