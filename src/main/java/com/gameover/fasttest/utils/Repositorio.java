package com.gameover.fasttest.utils;

import java.util.List;

public interface Repositorio<T> {

	/**
	 * Trae el registro por el id.
	 * 
	 * @param <S>
	 * @param id
	 * @return
	 */
	T getFotId(int id);

	/**
	 * Guarda el registro y devuelve una confirmación.
	 * 
	 * @param <S>
	 * @param entity
	 * @return
	 */
	boolean save(T entity);

	/**
	 * Elimina el registro y devuelve una confirmación.
	 * 
	 * @param <S>
	 * @param entity
	 * @return
	 */
	boolean delete(T entity);

	/**
	 * Elimina un registro apartir de su id.
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	/**
	 * Lista todos los registro de una clase.
	 * 
	 * @param <S>
	 * @return
	 */
	List<T> listAll();

}
