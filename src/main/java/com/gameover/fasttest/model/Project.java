package com.gameover.fasttest.model;

import java.util.List;

public class Project {

	private int id;
	private String name;
	private List<Definitions> definitions;
	private List<Steps> steps;
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

	public List<Definitions> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<Definitions> definitions) {
		this.definitions = definitions;
	}

	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}

	public List<PageObjects> getPageObjects() {
		return pageObjects;
	}

	public void setPageObjects(List<PageObjects> pageObjects) {
		this.pageObjects = pageObjects;
	}

}
