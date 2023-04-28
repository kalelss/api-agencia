package com.projectdev.agenciabf.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.agenciabf.dto.VooPilotoDTO;
import com.projectdev.agenciabf.entities.Piloto;
import com.projectdev.agenciabf.entities.Voo;
import com.projectdev.agenciabf.repositories.PilotoRepository;
import com.projectdev.agenciabf.repositories.VooRepository;

@RestController
@RequestMapping("/api/piloto")
public class PilotoController {

	@Autowired
	private PilotoRepository pilotoRepository;
	@Autowired
	private VooRepository vooRepository;
	
	@GetMapping("/buscartodos")
	public List<Piloto> buscarTodos(){
		return pilotoRepository.findAll();
	}
	
	@GetMapping("buscarvoospornomedata/{nome}/{data}")
	public List<VooPilotoDTO> buscarVooPorClienteData(@PathVariable(value="nome") String nome,
			@PathVariable(value="data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data){
		List<Voo> listaVoos = vooRepository.findAll();
		List<VooPilotoDTO> listaVooPorNomeData = new ArrayList<>();
		for (Voo voos : listaVoos) {
			if(voos.getPiloto().getNome().equalsIgnoreCase(nome) && voos.getData().equals(data)) {
				listaVooPorNomeData.add(new VooPilotoDTO(voos));
			}
		}
		return listaVooPorNomeData;
	}
	
	
	@PostMapping("/adicionar")
	public String adicionar(@RequestBody Piloto piloto) {
		pilotoRepository.save(piloto);
		return piloto.getNome();
	}
	
	@PutMapping("/editar")
	public String editar(@RequestBody Piloto piloto) {
		pilotoRepository.save(piloto);
		return piloto.getNome();
	}
	
	@DeleteMapping("/excluir")
	public void excluir(@RequestBody Piloto piloto) {
		pilotoRepository.delete(piloto);
	}
}
