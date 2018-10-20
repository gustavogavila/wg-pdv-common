package br.com.wg.wgpdv;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wg.wgpdv.domain.Cliente;
import br.com.wg.wgpdv.domain.Produto;
import br.com.wg.wgpdv.repositories.ClienteRepository;
import br.com.wg.wgpdv.repositories.ProdutoRepository;

@SpringBootApplication
public class WgPdvApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WgPdvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "João da Silva");
		Cliente c2 = new Cliente(null, "Creuza Soares");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		
		Produto p1 = new Produto(null, "Teclado", new BigDecimal(40.0));
		Produto p2 = new Produto(null, "Mouse", new BigDecimal(30.00));
		Produto p3 = new Produto(null, "Mouse Pad", new BigDecimal(10.00));
		Produto p4 = new Produto(null, "Caixas de som", new BigDecimal(35.00));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}
}
