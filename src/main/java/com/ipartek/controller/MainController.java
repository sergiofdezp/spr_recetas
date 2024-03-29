package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Dificultad;
import com.ipartek.model.Receta;
import com.ipartek.repository.DificultadRepository;
import com.ipartek.repository.RecetaRepository;

@Controller
public class MainController {
	
	@Autowired
	private RecetaRepository recetaRepo;
	
	@Autowired
	private DificultadRepository dificultadRepo;
	
	@RequestMapping("/")
	public String cargarHome(Model model) {
		List<Receta> listaRecetas = recetaRepo.findAll();		
		model.addAttribute("atr_lista_recetas", listaRecetas);
		
		// System.out.println(listaRecetas);
		
		return "index";
	}
	
	@RequestMapping("/guardar_receta")
	public String guardarReceta(@ModelAttribute Receta objeto_entidad, Model model) {
		recetaRepo.save(objeto_entidad);
		
		List<Dificultad> listaDificultades = dificultadRepo.findAll();		
		List<Receta> listaRecetas = recetaRepo.findAll();
		
		model.addAttribute("atr_lista_dificultades", listaDificultades);
		model.addAttribute("atr_lista_recetas", listaRecetas);

		return "redirect:/recetas";
	}
}
