package br.com.wg.wgpdv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	private Long codigo;
	
	@Column(name="quantidade", nullable=false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="produto_id", referencedColumnName="codigo")
	private Produto produto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="venda_id", referencedColumnName="codigo")
	private Venda venda;
	
	public Item() {
		
	}

	public Item(Long codigo, Integer quantidade, Produto produto, Venda venda) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.produto = produto;
		this.venda = venda;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
