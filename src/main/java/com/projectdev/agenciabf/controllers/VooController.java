package com.projectdev.agenciabf.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.agenciabf.dto.VooClienteDTO;
import com.projectdev.agenciabf.dto.VooDTO;
import com.projectdev.agenciabf.entities.Cliente;
import com.projectdev.agenciabf.entities.Pagamento;
import com.projectdev.agenciabf.entities.Piloto;
import com.projectdev.agenciabf.entities.Voo;
import com.projectdev.agenciabf.repositories.ClienteRepository;
import com.projectdev.agenciabf.repositories.PagamentoRepository;
import com.projectdev.agenciabf.repositories.PilotoRepository;
import com.projectdev.agenciabf.repositories.VooRepository;

@RestController
@RequestMapping("/api/voo")
public class VooController {

	@Autowired
	private VooRepository vooRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PilotoRepository pilotoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@GetMapping("/buscartodos")
	public ResponseEntity<List<VooDTO>> buscarTodos() {
		List<Voo> listaVoos = vooRepository.findAll();
		List<VooDTO> listaVoosDTO = listaVoos.stream().map(VooDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaVoosDTO);
	}

	@GetMapping("buscarpordata/{data}")
	public List<VooDTO> buscarVooPorData(
			@PathVariable(value = "data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
		List<Voo> listaVoos = vooRepository.findAll();
		List<VooDTO> listaVooPorData = new ArrayList<>();
		for (Voo voos : listaVoos) {
			if (voos.getData().equals(data)) {
				listaVooPorData.add(new VooDTO(voos));
			}
		}
		return listaVooPorData;
	}

	@GetMapping("buscarpornome/{nome}")
	public List<VooClienteDTO> buscarVoosPorNome(@PathVariable(value = "nome") String nome) {
		List<Voo> listaVoos = vooRepository.findAll();
		List<VooClienteDTO> listaVooPorNomeData = new ArrayList<>();
		for (Voo voos : listaVoos) {
			if (voos.getCliente().getNome().equalsIgnoreCase(nome)) {
				listaVooPorNomeData.add(new VooClienteDTO(voos));
			}
		}
		return listaVooPorNomeData;
	}

	@GetMapping("buscarpornomedata/{nome}/{data}")
	public List<Voo> buscarVooPorNomeData(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
		List<Voo> listaVoos = vooRepository.findAll();
		List<Voo> listaVooPorNomeData = new ArrayList<>();
		for (Voo voos : listaVoos) {
			if (voos.getCliente().getNome().equalsIgnoreCase(nome) && voos.getData().equals(data)) {
				listaVooPorNomeData.add(voos);
			}
		}
		return listaVooPorNomeData;
	}

	@PostMapping("/adicionar")
	public Voo adicionar(@RequestBody Voo voo) {
		Cliente cliente = clienteRepository.findById(voo.getCliente().getId()).orElseThrow();
		Piloto piloto = pilotoRepository.findById(voo.getPiloto().getId()).orElseThrow();

		voo.setCliente(cliente);
		voo.setPiloto(piloto);
		vooRepository.save(voo);
		Pagamento pagamento = new Pagamento(voo.getData(), -voo.getValorVoo(), cliente, voo.getId());

		pagamentoRepository.save(pagamento);
		return null;
	}

	@PutMapping("/alterar")
	public Voo alterar(@RequestBody Voo voo) {
		return vooRepository.save(voo);
	}

	@DeleteMapping("/excluir")
	public void excluir(@RequestBody Voo voo) {
		vooRepository.delete(voo);
	}
}
