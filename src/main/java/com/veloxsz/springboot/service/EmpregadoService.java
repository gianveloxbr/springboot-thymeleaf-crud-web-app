package com.veloxsz.springboot.service;

import java.util.List;

import com.veloxsz.springboot.model.Empregado;

public interface EmpregadoService {
	List <Empregado> getAllEmpregados();
	void salvarEmpregado(Empregado empregado);
	Empregado getEmpregadoById(long id);
	void deleteEmpregadoById(long id);
}
