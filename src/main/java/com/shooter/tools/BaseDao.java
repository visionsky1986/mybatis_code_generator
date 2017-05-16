package com.shooter.tools;

import java.util.List;

public interface BaseDao<T> {

	int save(T t) throws Exception;

	T get(long id) throws Exception;

	int delete(long id) throws Exception;

	int update(T t) throws Exception;

	List<T> getByParams(T t) throws Exception;

}
