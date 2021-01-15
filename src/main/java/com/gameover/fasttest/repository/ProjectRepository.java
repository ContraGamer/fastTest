package com.gameover.fasttest.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.gameover.fasttest.model.Project;
import com.gameover.fasttest.utils.Repository;
import com.google.gson.Gson;

public class ProjectRepository implements Repository<Project> {

	public static String URL = "/src/main/resources/json/Project.json";

	@Override
	public String cadenaFinal() {
		String cadena, cadenaFinal = "";

		try {
			FileReader archivoJSON = new FileReader(System.getProperty("user.dir") + URL);
			BufferedReader b = new BufferedReader(archivoJSON);
			while ((cadena = b.readLine()) != null) {
				cadenaFinal = cadenaFinal + cadena;
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cadenaFinal;
	}

	@Override
	public Project getFotId(int id) {
		Project value = new Project();
		try {

			Project[] project = null;
			Gson gson = new Gson();

			project = gson.fromJson(cadenaFinal(), Project[].class);
			for (Project p : project) {
				if (p.getId() == id) {
					value = p;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public boolean save(Project entity) {
		Project[] project = null;
		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			project = gson.fromJson(cadenaFinal(), Project[].class);

			int i = 0;
			boolean noExist = true;
			int valueId = 0;
			for (Project p : project) {
				valueId = p.getId();
				if (p.getId() == entity.getId()) {
					p = entity;
					project[i] = p;
					noExist = false;
				}

				i++;
			}
			Project paraSalida[];
			int j = 0;
			if (noExist) {
				paraSalida = new Project[project.length + 1];
				for (Project p : project) {
					paraSalida[j] = p;
					j++;
				}
				entity.setId(valueId + 1);
				paraSalida[j] = entity;
			} else {
				paraSalida = new Project[project.length];
				for (Project p : project) {
					paraSalida[j] = p;
					j++;
				}
			}
			fw = new FileWriter(f, false);
			fw.write("");
			fw.write(gson.toJson(paraSalida));
			fw.close();
			if (getFotId(entity.getId()).equals(entity)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Project entity) {
		Project[] project = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			project = gson.fromJson(cadenaFinal(), Project[].class);
			Project[] newRoles = new Project[project.length - 1];
			int i = 0;
			for (Project p : project) {
				if (p.getId() != entity.getId()) {
					newRoles[i] = p;
					i++;
				}
			}
			fw = new FileWriter(f, false);
			fw.write("");
			fw.write(gson.toJson(newRoles));
			fw.close();

		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		Project[] project = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			project = gson.fromJson(cadenaFinal(), Project[].class);
			Project[] newRoles = new Project[project.length - 1];
			int i = 0;
			for (Project p : project) {
				if (p.getId() != id) {
					newRoles[i] = p;
					i++;
				}
			}
			fw = new FileWriter(f, false);
			fw.write("");
			fw.write(gson.toJson(newRoles));
			fw.close();

		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Project> listAll() {
		List<Project> newList = new ArrayList<Project>();
		Project[] project = null;
		try {
			Gson gson = new Gson();
			project = gson.fromJson(cadenaFinal(), Project[].class);
			for (Project p : project) {
				newList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

}
