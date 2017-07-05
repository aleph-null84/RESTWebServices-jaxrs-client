package com.yuriy.traning.messenger.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
			
	public Message() {
		super();
	}
	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		//this.created = new Date();
		try {
			this.created = formatter.parse("2015-03-08");
		} catch (ParseException e) {
			this.created = new Date();
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
