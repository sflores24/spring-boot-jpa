package mx.com.personal.springboot.app.models.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.com.personal.springboot.app.models.dao.IClientDAO;
import mx.com.personal.springboot.app.models.entity.Cliente;

@Repository("clienteDAOJPA")
public class ClienteDAOImpl implements IClientDAO {
	private static final String FROM = "FROM Cliente";

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return em.createQuery(FROM).getResultList();
	}
	
	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);	
		} else {
			em.persist(cliente);
		}
	}
	
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {
		Cliente cliente = findOne(id);
		if(cliente != null) {
			em.remove(cliente);	
		}
	}
}
