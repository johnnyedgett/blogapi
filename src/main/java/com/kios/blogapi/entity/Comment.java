package com.kios.blogapi.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Comment {

	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
