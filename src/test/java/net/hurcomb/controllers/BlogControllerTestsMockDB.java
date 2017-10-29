package net.hurcomb.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import net.hurcomb.domain.Blog;
import net.hurcomb.service.BlogRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BlogControllerTestsMockDB {
	
	@Autowired
	private MockMvc mockMvc;
	
    @MockBean
    private BlogRepository repository;

	@Test
	public void getBlogShouldReturnABlog() throws Exception {

		given(this.repository.getBlog(Optional.of(1))).willReturn( new Blog("XYZ", null) );
				
		this.mockMvc.perform(get("/blog?id=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.markdown").value("XYZ"));
	}
	
}
