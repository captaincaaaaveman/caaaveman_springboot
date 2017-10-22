package net.hurcomb.controllers;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import net.hurcomb.domain.Markdown;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MarkdownController {

    private static final String template = "# Markdown";

    @RequestMapping("/markdown")
    public Markdown greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Markdown md = new Markdown( template, Arrays.asList( "Java", "SpringBoot" ) );
        return md;
    }
}
