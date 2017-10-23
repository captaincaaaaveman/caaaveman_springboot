package net.hurcomb.service;

import org.springframework.stereotype.Repository;

import net.hurcomb.domain.Blog;

@Repository
public interface BlogRepository {

	public Blog getBlog();

}
