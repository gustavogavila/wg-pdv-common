package br.com.wg.wgpdv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wg.wgpdv.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
