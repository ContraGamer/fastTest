package com.gameover.fasttest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.gameover.fasttest.model.Parameters;
import com.gameover.fasttest.model.User;
import com.google.gson.Gson;



public class ReadJSON {
	
	
	/**
	 * Lee el archivo json y lo trae en forma String
	 * 
	 * @return
	 */
	 public String cadenaFinal() {
		String cadena, cadenaFinal = "";

		try {
			FileReader archivoJSON = new FileReader(System.getProperty("user.dir") + "/src/resources/parametros.json");
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

	/**
	 * Trae un parametro dependiendo el key pertinente.
	 * 
	 * @param key
	 * @return
	 */
	public String traeValueParam(String key) {
		String value = "Valor no encontrado";
		try {

			Parameters[] parametros = null;
			Gson gson = new Gson();

			parametros = gson.fromJson(cadenaFinal(), Parameters[].class);
			for (Parameters p : parametros) {
				if (p.getKey().equalsIgnoreCase(key)) {
					value = p.getValue();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}

	public String readEditParam(Parameters parametro) {
		Parameters[] parametros = null;
		try {
			File f = new File(
					System.getProperty("user.dir") + "/src/resources/parametros.json");
			FileWriter fw;
			Gson gson = new Gson();
			parametros = gson.fromJson(cadenaFinal(), Parameters[].class);

			int i = 0;
			boolean noExist = true;

			for (Parameters p : parametros) {
				if (p.getKey().equalsIgnoreCase(parametro.getKey())) {
					p.setValue(parametro.getValue());
					parametros[i] = p;
					noExist = false;
				}

				i++;
			}
			Parameters paraSalida[];
			int j = 0;
			if (noExist) {
				paraSalida = new Parameters[parametros.length + 1];
				for (Parameters p : parametros) {
					paraSalida[j] = p;
					j++;
				}
				paraSalida[j] = parametro;
			} else {
				paraSalida = new Parameters[parametros.length];
				for (Parameters p : parametros) {
					paraSalida[j] = p;
					j++;
				}
			}
			fw = new FileWriter(f, false);
			fw.write("");
			fw.write(gson.toJson(paraSalida));
			fw.close();
			if (traeValueParam(parametro.getKey()).equalsIgnoreCase(parametro.getValue())) {
				return "Se agregó correctamente el parametro.";
			} else {
				return "Ha ocurrido algo, no se agrego el parametro.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "No se ha agregado el parametro indicado.";
		}

	}

	public static void main(String args[]) {
		//System.out.println(new ParametrosServicio().readEditParam(new Parametros("user", "oeposada")));
		//System.out.println(new ParametrosServicio().traeValueParam("Alm_Url"));
	}

}
