package br.com.wg.wgpdv.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wg.wgpdv.bo.exceptions.ObjetoNaoEncontradoException;
import br.com.wg.wgpdv.domain.Item;
import br.com.wg.wgpdv.repositories.ItemRepository;

@Service
public class ItemBO {

	@Autowired
	private ItemRepository repo;

	public Item findById(Long id) {
		Optional<Item> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! Código: " + id + ", Tipo: " + Item.class.getName()));
	}
}
