package com.projectdev.agenciabf.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.agenciabf.dto.PagamentoDTO;
import com.projectdev.agenciabf.entities.Cliente;
import com.projectdev.agenciabf.entities.Pagamento;
import com.projectdev.agenciabf.repositories.ClienteRepository;
import com.projectdev.agenciabf.repositories.PagamentoRepository;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/buscartodos")
	public ResponseEntity<List<PagamentoDTO>> buscarTodos() {
		List<Pagamento> listapagamentos = pagamentoRepository.findAll();
		List<PagamentoDTO> listaPagamentosDTO = listapagamentos.stream().map(PagamentoDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaPagamentosDTO);
	}
	
	@GetMapping("buscarpordata/{data}")
	public List<PagamentoDTO> buscarVooPorData(
			@PathVariable(value = "data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
		List<Pagamento> listaPagamentos = pagamentoRepository.findAll();
		List<PagamentoDTO> listaPagamentosPorData = new ArrayList<>();
		for (Pagamento pagamentos : listaPagamentos) {
			if (pagamentos.getData().equals(data) && pagamentos.getValorPagamento() > 0) {
				listaPagamentosPorData.add(new PagamentoDTO(pagamentos));
			}
		}
		return listaPagamentosPorData;
	}
	
	@GetMapping("buscarpornome/{nome}")
	public List<PagamentoDTO> buscarVoosPorNome(@PathVariable(value = "nome") String nome) {
		List<Pagamento> listaPagamentos = pagamentoRepository.findAll();
		List<PagamentoDTO> listaPagamentosPorData = new ArrayList<>();
		for (Pagamento pagamentos : listaPagamentos) {
			if (pagamentos.getCliente().getNome().equalsIgnoreCase(nome)) {
				listaPagamentosPorData.add(new PagamentoDTO(pagamentos));
			}
		}
		return listaPagamentosPorData;
	}

	@GetMapping("buscarpornomedata/{nome}/{data}")
	public List<PagamentoDTO> buscarVooPorNomeData(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
		List<Pagamento> listaPagamentos = pagamentoRepository.findAll();
		List<PagamentoDTO> listaPagamentosPorData = new ArrayList<>();
		for (Pagamento pagamentos : listaPagamentos) {
			if (pagamentos.getCliente().getNome().equalsIgnoreCase(nome) && pagamentos.getData().equals(data)) {
				listaPagamentosPorData.add(new PagamentoDTO(pagamentos));
			}
		}
		return listaPagamentosPorData;
	}
	
	@PostMapping("/adicionar")
	public Pagamento adicionar(@RequestBody Pagamento pagamento) {
		Cliente cliente = clienteRepository.findById(pagamento.getCliente().getId()).orElseThrow();
		pagamento.setCliente(cliente);
		pagamentoRepository.save(pagamento);
		return null;
	}
}