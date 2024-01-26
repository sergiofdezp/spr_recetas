package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Dificultad;
import com.ipartek.model.Receta;
import com.ipartek.repository.DificultadRepository;
import com.ipartek.repository.RecetaRepository;

@Controller
public class MenuController {
	@Autowired
	private RecetaRepository recetaRepo;
	
	@Autowired
	private DificultadRepository dificultadRepo;
	
	@RequestMapping("/recetas")
	public String cargarRecetas(Model model) {
		List<Receta> listaRecetas = recetaRepo.findAll();		
		model.addAttribute("atr_lista_recetas", listaRecetas);
		model.addAttribute("objeto_entidad", new Receta());
		
		// System.out.println(listaRecetas);
		
		return "index";
	}
	
	@RequestMapping("/nueva_receta")
	public String nuevaReceta(Model model) {
		List<Dificultad> listaDificultades = dificultadRepo.findAll();		
		model.addAttribute("atr_lista_dificultades", listaDificultades);
		model.addAttribute("objeto_entidad", new Receta());
		
		return "nueva_receta";
	}
}
