package br.com.wg.wgpdv;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wg.wgpdv.domain.Cliente;
import br.com.wg.wgpdv.domain.Item;
import br.com.wg.wgpdv.domain.Produto;
import br.com.wg.wgpdv.domain.Venda;
import br.com.wg.wgpdv.repositories.ClienteRepository;
import br.com.wg.wgpdv.repositories.ItemRepository;
import br.com.wg.wgpdv.repositories.ProdutoRepository;
import br.com.wg.wgpdv.repositories.VendaRepository;

@SpringBootApplication
public class WgPdvApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
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
		
		Venda v1 = new Venda(null, LocalDateTime.of(2018, Month.OCTOBER, 1, 8, 30), c1);
		Venda v2 = new Venda(null, LocalDateTime.of(2018, Month.OCTOBER, 1, 9, 5), c2);
		
		vendaRepository.saveAll(Arrays.asList(v1, v2));
		
		Item i1v1 = new Item(null, 2, p1);
		Item i2v1 = new Item(null, 2, p2);
		Item i3v1 = new Item(null, 2, p3);
		
		Item i1v2 = new Item (null, 1, p4);
		
		v1.getItens().addAll(Arrays.asList(i1v1, i2v1, i3v1));
		v2.getItens().add(i1v2);

		itemRepository.saveAll(Arrays.asList(i1v1, i2v1, i3v1, i1v2));
		
		
	}
}
