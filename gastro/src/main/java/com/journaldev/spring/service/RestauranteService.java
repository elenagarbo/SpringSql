package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Restaurante;

public interface RestauranteService {

	public void addRestaurante(Restaurante p);
	public void updateRestaurante(Restaurante p);
	public List<Restaurante> listRestaurantes();
	public Restaurante getRestauranteById(int id);
	public void removeRestaurante(int id);
	
}
