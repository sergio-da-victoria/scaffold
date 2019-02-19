package br.com.open.eip.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.open.eip.entity.Produto;


@Stateless(name="ProdutoRepository")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProdutoRepositoryImpl implements ProdutoRepository {
	
	
	
	@PersistenceContext(unitName = "scaffold-persistence-unit")
	private EntityManager em;


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(Produto entity) {
		getEm().persist(entity);
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Produto bydIdProduto(Integer seqproduto) {
		Query query = getEm().createNamedQuery("find.bydIdProduto",Produto.class);
		query.setParameter("seqproduto",seqproduto);
		List<Produto> produtos = (List<Produto>) query.getResultList();
		return produtos.size() > 0 ? produtos.get(0) : null;
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Produto byNameProduto(String desccompleta) {
		Query query = getEm().createNamedQuery("find.byNameProduto",Produto.class);
		query.setParameter("desccompleta",desccompleta);
		List<Produto> produtos = (List<Produto>) query.getResultList();
		return produtos.size() > 0 ? produtos.get(0) : null; 	
	}
	
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Produto> allProduto( ) {
		Query query = getEm().createNamedQuery("find.allProduto",Produto.class);
		return (List<Produto>) query.getResultList();
	}
	
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteById(Integer id) {
		Produto entity = getEm().find(Produto.class, id);
		if (entity != null) {
			getEm().remove(entity);
		}
	}


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Produto findById(Integer id) {
		return getEm().find(Produto.class, id);
	}

	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Produto update(Produto entity) {
		return getEm().merge(entity);
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Integer IsOK( ) {
		return new Integer(1);
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Produto> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Produto> findAllQuery = getEm().createQuery("SELECT DISTINCT p FROM Produto p ORDER BY p.seqproduto",Produto.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Boolean delete() {
		Query query = getEm().createNamedQuery("find.delete");
		int teste = query.executeUpdate();
		return teste > 0 ? Boolean.TRUE : Boolean.FALSE;
	}


	public EntityManager getEm() {
		return em;
	}



	
}
