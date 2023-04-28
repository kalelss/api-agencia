package com.projectdev.agenciabf.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb-pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	private Double valorPagamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Long vooId;

    public Pagamento() {
    }
    
    
	public Pagamento(Date data, Double valorPagamento, Cliente cliente, Long vooId) {
		this.data = data;
		this.valorPagamento = valorPagamento;
		this.cliente = cliente;
		this.vooId = vooId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public Long getVooId() {
		return vooId;
	}
	public void setVooId(Long vooId) {
		this.vooId = vooId;
	}
}
