package com.gameover.fasttest.model;

import java.util.List;

public class Steps {

	private int id;
	private String name;
	private List<PageObjects> pageObjects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PageObjects> getPageObjects() {
		return pageObjects;
	}

	public void setPageObjects(List<PageObjects> pageObjects) {
		this.pageObjects = pageObjects;
	}

}
