package br.com.wg.wgpdv.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wg.wgpdv.bo.exceptions.ObjetoNaoEncontradoException;
import br.com.wg.wgpdv.domain.Produto;
import br.com.wg.wgpdv.repositories.ProdutoRepository;

@Service
public class ProdutoBO {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto findById(Long codigo) {
		Optional<Produto> obj = repo.findById(codigo);
		return obj.orElseThrow(() -> 
			new ObjetoNaoEncontradoException(
				"Objeto não encontrado! Codigo: " + codigo + 
					", Tipo: " + Produto.class.getName()));
	}
}
