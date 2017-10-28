package net.hurcomb.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import net.hurcomb.domain.Blog;
import net.hurcomb.service.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class BlogController {

    private static final String template = "# Markdown";

    @Autowired
    BlogRepository br;
    
    @RequestMapping("/blog")
    public Blog getBlog(@RequestParam(value="id") Optional<Integer> id) {
    	return br.getBlog(id);
    }

    @RequestMapping("/allBlogs")
    public List<Blog> getAllBlogs() {
    	return br.getBlogs();
    }

}
