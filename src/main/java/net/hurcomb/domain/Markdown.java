package net.hurcomb.domain;

import java.util.List;

public class Markdown {

	String markdown;
	List<String> tags;
	
	public Markdown(String markdown, List<String> tags) {
		this.markdown = markdown;
		this.tags = tags;
	}
	public String getMarkdown() {
		return markdown;
	}
	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void addTag(String tag) {
		this.tags.add(tag); 
	}

}
