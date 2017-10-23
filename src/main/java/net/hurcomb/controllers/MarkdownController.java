package net.hurcomb.controllers;

import java.util.Arrays;
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
public class MarkdownController {

    private static final String template = "# Markdown";

    @Autowired
    BlogRepository br;
    
    @RequestMapping("/markdown")
    public Blog markdown(@RequestParam(value="name", defaultValue="World") String name) {
//        Blog md = new Blog( template, Arrays.asList( "Java", "SpringBoot" ) );
//        return md;
    	return br.getBlog();
    }
}
