package br.com.wg.wgpdv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wg.wgpdv.bo.ProdutoBO;
import br.com.wg.wgpdv.domain.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoBO bo;
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long codigo) {
		Produto obj = bo.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}
}