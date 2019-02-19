package br.com.open.eip.repository;

import java.util.List;

import javax.ejb.Local;

import br.com.open.eip.entity.Produto;

@Local
public interface ProdutoRepository {
	public void create(Produto entity);
	public Produto bydIdProduto(Integer seqproduto);
	public Produto byNameProduto(String desccompleta);
	public List<Produto> allProduto();
	public void deleteById(Integer id);
	public Produto findById(Integer id);
	public Produto update(Produto entity);
	public Boolean delete( );
	public Integer IsOK();
	public List<Produto> listAll(Integer startPosition, Integer maxResult);
}