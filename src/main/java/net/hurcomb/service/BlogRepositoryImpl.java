package net.hurcomb.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.hurcomb.domain.Blog;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Blog getBlog( Optional<Integer> id ) {
		
		String sql = "select id, markdown, tags from blog ";
		
		sql = sql + id.map(i->String.format(" where id = %d",i)).orElse(" where id = 1");
		
		return jdbcTemplate.query(sql, 
				rs -> { 
					rs.next();
					return new Blog(rs.getString("markdown"), 
							Arrays.asList( rs.getString("tags").split(",") ) ); 
				} );
	}

	@Override
	public List<Blog> getBlogs() {		
		return jdbcTemplate.query("select id, markdown, tags from blog", 
			(rs, rownum) -> {
				return new Blog(rs.getString("markdown"), 
						Arrays.asList( rs.getString("tags").split(",") ) ); 
			});
	}

}
