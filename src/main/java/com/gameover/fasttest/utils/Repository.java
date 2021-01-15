package com.gameover.fasttest.utils;

import java.util.List;

public interface Repository<T> {

	/**
	 * Lee el archivo json y lo trae en forma String
	 * 
	 * @return
	 */
	public String cadenaFinal();

	/**
	 * Obtiene el registro por medio de un id.
	 * 
	 * @param id
	 * @return
	 */
	public T getFotId(int id);

	/**
	 * Guarda el registro ingresado.
	 * 
	 * @param entity
	 * @return
	 */
	public boolean save(T entity);

	/**
	 * Elimina el registro ingresado
	 * 
	 * @param entity
	 * @return
	 */
	public boolean delete(T entity);

	/**
	 * Elimina el registro por medio de id
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * Lista todos los registros.
	 */
	public List<T> listAll();

}
