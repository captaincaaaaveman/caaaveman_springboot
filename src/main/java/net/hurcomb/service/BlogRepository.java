package net.hurcomb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.hurcomb.domain.Blog;

@Repository
public interface BlogRepository {

	public Blog getBlog(Optional<Integer> id);

	public List<Blog> getBlogs();

}
