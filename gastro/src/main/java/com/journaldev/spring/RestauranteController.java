package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Restaurante;
import com.journaldev.spring.service.RestauranteService;

@Controller
public class RestauranteController {
	
	private RestauranteService restauranteService;
	
	@Autowired(required=true)
	@Qualifier(value="restauranteService")
	public void setrestauranteService(RestauranteService ps){
		this.restauranteService = ps;
	}
	
	@RequestMapping(value = "/restaurante", method = RequestMethod.GET)
	public String listRestaurantes(Model model) {
		model.addAttribute("restaurante", new Restaurante());
		model.addAttribute("listRestaurantes", this.restauranteService.listRestaurantes());
		return "restaurante";
	}
	
	//For add and update person both
	@RequestMapping(value= "/restaurante/add", method = RequestMethod.POST)
	public String addRestaurante(@ModelAttribute("restaurante") Restaurante p){
		
		if(p.getId() == 0){
			//new person, add it
			this.restauranteService.addRestaurante(p);
		}else{
			//existing person, call update
			this.restauranteService.updateRestaurante(p);
		}
		
		return "redirect:/restaurante";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeRestaurante(@PathVariable("id") int id){
		
        this.restauranteService.removeRestaurante(id);
        return "redirect:/restaurante";
    }
 
    @RequestMapping("/edit/{id}")
    public String editRestaurante(@PathVariable("id") int id, Model model){
        model.addAttribute("restaurante", this.restauranteService.getRestauranteById(id));
        model.addAttribute("listRestaurantes", this.restauranteService.listRestaurantes());
        return "restaurante";
    }
	
}
