package com.veloxsz.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.veloxsz.springboot.model.Empregado;
import com.veloxsz.springboot.repository.EmpregadoRepository;

@Service
public class EmpregadoServiceImpl implements EmpregadoService {
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	@Override
	public List <Empregado> getAllEmpregados() {
		return empregadoRepository.findAll();
	}
	
	@Override
	public void salvarEmpregado(Empregado empregado) {
		this.empregadoRepository.save(empregado);
	}
	
	@Override
	public Empregado getEmpregadoById(long id) {
		Optional <Empregado> opcional = empregadoRepository.findById(id);
		Empregado empregado = null;
		if (opcional.isPresent()) {
			empregado = opcional.get();
		} else {
			throw new RuntimeException(" Empregado não encontrado pelo id :: " + id);
		}
		return empregado;
	}
	
	@Override
	public void deleteEmpregadoById(long id) {
		this.empregadoRepository.deleteById(id);
	}
}
