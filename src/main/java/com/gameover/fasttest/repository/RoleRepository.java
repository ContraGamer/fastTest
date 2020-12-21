package com.gameover.fasttest.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.gameover.fasttest.model.Role;
import com.google.gson.Gson;

public class RoleRepository {

	public static String URL = "/src/main/resources/json/Role.json";

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

	public Role traeRoleId(int id) {
		Role value = new Role();
		try {

			Role[] role = null;
			Gson gson = new Gson();

			role = gson.fromJson(cadenaFinal(), Role[].class);
			for (Role p : role) {
				if (p.getId() == id) {
					value = p;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String saveRole(Role role) {
		Role[] roles = null;
		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			roles = gson.fromJson(cadenaFinal(), Role[].class);

			int i = 0;
			boolean noExist = true;
			int valueId = 0;
			for (Role p : roles) {
				valueId = p.getId();
				if (p.getId() == role.getId()) {
					p = role;
					roles[i] = p;
					noExist = false;
				}

				i++;
			}
			Role paraSalida[];
			int j = 0;
			if (noExist) {
				paraSalida = new Role[roles.length + 1];
				for (Role p : roles) {
					paraSalida[j] = p;
					j++;
				}
				role.setId(valueId + 1);
				paraSalida[j] = role;
			} else {
				paraSalida = new Role[roles.length];
				for (Role p : roles) {
					paraSalida[j] = p;
					j++;
				}
			}
			fw = new FileWriter(f, false);
			fw.write("");
			fw.write(gson.toJson(paraSalida));
			fw.close();
			if (traeRoleId(role.getId()).equals(role)) {
				return "Se agregó correctamente el role.";
			} else {
				return "Ha ocurrido algo, no se agrego el role.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "No se ha agregado el dato indicado.";
		}

	}

	public void deleteRole(Role role) {
		Role[] roles = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			roles = gson.fromJson(cadenaFinal(), Role[].class);
			Role[] newRoles = new Role[roles.length - 1];
			int i = 0;
			for (Role p : roles) {
				if (p.getId() != role.getId()) {
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

		}
	}

	public void deleteRole(int id) {
		Role[] roles = null;

		try {
			File f = new File(System.getProperty("user.dir") + URL);
			FileWriter fw;
			Gson gson = new Gson();
			
			roles = gson.fromJson(cadenaFinal(), Role[].class);
			Role[] newRoles = new Role[roles.length - 1];
			int i = 0;
			for (Role p : roles) {
				
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

		}
	}

	public static void main(String[] args) {
		RoleRepository roleRepository = new RoleRepository();
		Role role = new Role();
//		role.setId(2);
//		role.setName("Empleado");
//		role.setState("A");
//		roleRepository.saveRole(role);
//		Role role = roleRepository.traeRoleId(3);
//		System.out.println(role.getName());
		roleRepository.deleteRole(2);
	}

}
