package br.com.wg.wgpdv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wg.wgpdv.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
