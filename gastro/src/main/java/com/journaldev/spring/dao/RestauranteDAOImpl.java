package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Restaurante;

@Repository
public class RestauranteDAOImpl implements RestauranteDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RestauranteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addRestaurante(Restaurante p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Restaurante saved successfully, Restaurante Details="+p);
	}

	public void updateRestaurante(Restaurante p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Restaurante updated successfully, Restaurante Details="+p);
	}

	@SuppressWarnings("unchecked")
	public List<Restaurante> listRestaurantes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Restaurante> restaurantesList = session.createQuery("from Restaurante").list();
		for(Restaurante p : restaurantesList){
			logger.info("Restaurante List::"+p);
		}
		return restaurantesList;
	}

	public Restaurante getRestauranteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Restaurante p = (Restaurante) session.load(Restaurante.class, new Integer(id));
		logger.info("Restaurante loaded successfully, Restaurante details="+p);
		return p;
	}

	public void removeRestaurante(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Restaurante p = (Restaurante) session.load(Restaurante.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Restaurante deleted successfully, restaurante details="+p);
	}

}
