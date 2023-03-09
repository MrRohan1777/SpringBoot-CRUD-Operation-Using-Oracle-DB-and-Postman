package com.jpa.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	private String fristName;
	private String lastName;
	private String language;

	public Author() {
		super();
	}

	public Author(int authorId, String fristName, String lastName, String language) {
		super();
		this.authorId = authorId;
		this.fristName = fristName;
		this.lastName = lastName;
		this.language = language;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", fristName=" + fristName + ", lastName=" + lastName + ", language="
				+ language + "]";
	}

}
