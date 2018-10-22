package br.com.wg.wgpdv.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wg.wgpdv.bo.exceptions.ObjetoNaoEncontradoException;
import br.com.wg.wgpdv.domain.Cliente;
import br.com.wg.wgpdv.repositories.ClienteRepository;

@Service
public class ClienteBO {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Long codigo) {
		Optional<Cliente> obj = repo.findById(codigo);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! Codigo: " + codigo + ", Tipo: " + Cliente.class.getName()));
	}
	
}
