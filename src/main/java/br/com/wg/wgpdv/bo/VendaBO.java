package br.com.wg.wgpdv.bo;

import java.util.List;
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

	public Venda findById(Long id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName()));
	}

	public List<Venda> findAll() {
		List<Venda> vendas = repo.findAll();
		return vendas;
	}

	public Venda save(Venda venda) {
		venda.setId(null);
		return repo.save(venda);
	}

//	public void deleteById(Long id) {
//		if (id != null) {
//			repo.deleteById(id);
//		} else {
//			new ObjetoNaoEncontradoException("Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName());
//		}
//	}

}
