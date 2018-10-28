package br.com.wg.wgpdv.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wg.wgpdv.bo.VendaBO;
import br.com.wg.wgpdv.domain.Venda;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaBO bo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Venda obj = bo.findById(id);
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Venda> vendas = bo.findAll();
		return ResponseEntity.ok().body(vendas);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(Venda venda) {
		venda = bo.save(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
