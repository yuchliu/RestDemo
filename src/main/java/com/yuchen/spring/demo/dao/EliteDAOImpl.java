package com.yuchen.spring.demo.dao;

import java.util.List;

import com.yuchen.spring.demo.entity.Elite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EliteDAOImpl implements EliteDAO {

	// need to inject the session factory
	private SessionFactory sessionFactory;

	public EliteDAOImpl() {
	}

	@Autowired
	public EliteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Elite> getElites() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Elite> theQuery =
				currentSession.createQuery("from com.yuchen.spring.demo.entity.Elite order by lastName",
											Elite.class);
		
		// execute query and get result list
		List<Elite> elites = theQuery.getResultList();
				
		// return the results		
		return elites;
	}

	@Override
	public void saveElite(Elite theElite) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the elite ... finally LOL
		currentSession.saveOrUpdate(theElite);
		
	}

	@Override
	public Elite getElite(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Elite theElite = currentSession.get(Elite.class, theId);
		
		return theElite;
	}

	@Override
	public void deleteElite(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from com.yuchen.spring.demo.entity.Elite where id=:eliteId");
		theQuery.setParameter("eliteId", theId);
		
		theQuery.executeUpdate();		
	}

}











