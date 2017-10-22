package net.hurcomb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import net.hurcomb.domain.Blog;

public class BlogRepositoryImpl implements BlogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Blog getBlog() {
		return null;
	}

}
