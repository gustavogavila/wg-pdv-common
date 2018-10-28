package br.com.wg.wgpdv.bo;

import java.util.List;
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

	public Produto findById(Long id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public List<Produto> findAll() {
		List<Produto> produtos = repo.findAll();
		return produtos;
	}

}
