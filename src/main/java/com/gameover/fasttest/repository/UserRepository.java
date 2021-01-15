package com.gameover.fasttest.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.gameover.fasttest.model.User;
import com.google.gson.Gson;

public class UserRepository {

	public static String URL = "/src/main/resources/json/User.json";

	/**
	 * Lee el archivo json y lo trae en forma String
	 * 
	 * @return
	 */
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

	public User getFotId(int id) {
		User value = new User();
		try {
			User[] user = null;
			Gson gson = new Gson();
			user = gson.fromJson(cadenaFinal(), User[].class);
			for (User p : user) {
				if (p.getId() == id) {
					value = p;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public boolean save(User entity) {
		User[] user = null;
		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			user = gson.fromJson(cadenaFinal(), User[].class);

			int i = 0;
			boolean noExist = true;
			int valueId = 0;
			for (User p : user) {
				valueId = p.getId();
				if (p.getId() == entity.getId()) {
					p = entity;
					user[i] = p;
					noExist = false;
				}

				i++;
			}
			User paraSalida[];
			int j = 0;
			if (noExist) {
				paraSalida = new User[user.length + 1];
				for (User p : user) {
					paraSalida[j] = p;
					j++;
				}
				entity.setId(valueId + 1);
				paraSalida[j] = entity;
			} else {
				paraSalida = new User[user.length];
				for (User p : user) {
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

	public boolean delete(User entity) {
		User[] users = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			users = gson.fromJson(cadenaFinal(), User[].class);
			User[] newRoles = new User[users.length - 1];
			int i = 0;
			for (User p : users) {
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

	public boolean delete(int id) {
		User[] users = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			users = gson.fromJson(cadenaFinal(), User[].class);
			User[] newRoles = new User[users.length - 1];
			int i = 0;
			for (User p : users) {
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

	public List<User> listAll() {
		List<User> newList = new ArrayList<User>();
		User[] users = null;
		try {
			Gson gson = new Gson();
			users = gson.fromJson(cadenaFinal(), User[].class);
			for (User p : users) {
				newList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

}
