package net.hurcomb.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.hurcomb.domain.Blog;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Blog getBlog() {		
		return jdbcTemplate.query("select id, markdown, tags from blog where id = 1", 
				rs -> { 
					rs.next();
					return new Blog(rs.getString("markdown"), 
							Arrays.asList( rs.getString("tags").split(",") ) ); 
				} );
	}

}
