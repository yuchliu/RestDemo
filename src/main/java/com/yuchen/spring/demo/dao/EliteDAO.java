package com.yuchen.spring.demo.dao;

import com.yuchen.spring.demo.entity.Elite;

import java.util.List;



public interface EliteDAO {

	public List<Elite> getElites();

	public void saveElite(Elite theElite);

	public Elite getElite(int theId);

	public void deleteElite(int theId);
	
}
