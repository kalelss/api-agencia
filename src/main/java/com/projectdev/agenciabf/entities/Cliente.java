package com.projectdev.agenciabf.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-cliente")
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente")
    private List<Pagamento> pagamentos;
	
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
}
