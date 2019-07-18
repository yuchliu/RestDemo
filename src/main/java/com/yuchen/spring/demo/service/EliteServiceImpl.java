package com.yuchen.spring.demo.service;

import java.util.List;

import com.yuchen.spring.demo.dao.EliteDAO;
import com.yuchen.spring.demo.entity.Elite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EliteServiceImpl implements EliteService {

	// need to inject elite dao

	private EliteDAO eliteDAO;

	public EliteServiceImpl() {
	}

	@Autowired
	public EliteServiceImpl(EliteDAO eliteDAO) {
		this.eliteDAO = eliteDAO;
	}

	@Override
	@Transactional
	public List<Elite> getElites() {
		return eliteDAO.getElites();
	}

	@Override
	@Transactional
	public void saveElite(Elite theElite) {

		eliteDAO.saveElite(theElite);
	}

	@Override
	@Transactional
	public Elite getElite(int theId) {
		
		return eliteDAO.getElite(theId);
	}

	@Override
	@Transactional
	public void deleteElite(int theId) {
		
		eliteDAO.deleteElite(theId);
	}
}





