package com.veloxsz.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.veloxsz.springboot.model.Empregado;
import com.veloxsz.springboot.service.EmpregadoService;

@Controller
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService empregadoService;
	
	//Mostrar lista de empregados
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listaEmpregados", empregadoService.getAllEmpregados());
		return "index";
	}
	
	@GetMapping("/showNovoEmpregadoForm")
	public String showNovoEmpregadoForm(Model model) {
		// criar atributo de modelo para vincular dados do formulário
		Empregado empregado = new Empregado();
		model.addAttribute("empregado", empregado);
		return "novo_empregado";
	}
	
	@PostMapping("/salvarEmpregado")
	public String salvarEmpregado(@ModelAttribute("empregado") Empregado empregado) {
		// salvar empregado no banco de dados
		empregadoService.salvarEmpregado(empregado);
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
		//pega empregado da service
		Empregado empregado = empregadoService.getEmpregadoById(id);
		
		// define empregado como atributo do modelo para preencher o formulário previamente
		model.addAttribute("empregado", empregado);
		return "update_empregado";
	}
	
	@GetMapping("/deleteEmpregado/{id}")
	public String deleteEmpregado(@PathVariable(value = "id") long id) {
		
		// chamar método deleteEmpregado
		this.empregadoService.deleteEmpregadoById(id);
		return "redirect:/";
	}
}
