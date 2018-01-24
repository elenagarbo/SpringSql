package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.RestauranteDAO;
import com.journaldev.spring.model.Restaurante;

@Service
public class RestauranteServiceImpl implements RestauranteService {
	
	private RestauranteDAO restauranteDAO;

	public void setRestauranteDAO(RestauranteDAO restauranteDAO) {
		this.restauranteDAO = restauranteDAO;
	}

	@Transactional
	public void addRestaurante(Restaurante p) {
		this.restauranteDAO.addRestaurante(p);
	}

	@Transactional
	public void updateRestaurante(Restaurante p) {
		this.restauranteDAO.updateRestaurante(p);
	}

	@Transactional
	public List<Restaurante> listRestaurantes() {
		return this.restauranteDAO.listRestaurantes();
	}

	@Transactional
	public Restaurante getRestauranteById(int id) {
		return this.restauranteDAO.getRestauranteById(id);
	}

	@Transactional
	public void removeRestaurante(int id) {
		this.restauranteDAO.removeRestaurante(id);
	}

}
