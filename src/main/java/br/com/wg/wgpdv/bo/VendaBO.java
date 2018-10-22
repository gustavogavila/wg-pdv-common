package br.com.wg.wgpdv.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wg.wgpdv.bo.exceptions.ObjetoNaoEncontradoException;
import br.com.wg.wgpdv.domain.Venda;
import br.com.wg.wgpdv.repositories.VendaRepository;

@Service
public class VendaBO {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda findById(Long codigo) {
		Optional<Venda> obj = repo.findById(codigo);
		return obj.orElseThrow(() -> 
			new ObjetoNaoEncontradoException(
				"Objeto não encontrado! Codigo: " + codigo + 
					", Tipo: " + Venda.class.getName()));
	}
}
