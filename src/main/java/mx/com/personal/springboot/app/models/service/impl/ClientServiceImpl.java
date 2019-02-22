package mx.com.personal.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.personal.springboot.app.models.dao.IClientDAO;
import mx.com.personal.springboot.app.models.entity.Cliente;
import mx.com.personal.springboot.app.models.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	@Qualifier("clienteDAOJPA")//Este solo es necesario en caso de que mas de una interfaz lo implemente
	private IClientDAO clientDAO;
	
	@Override
	public List<Cliente> findAll() {
		return clientDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clientDAO.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clientDAO.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDAO.delete(id);
	}

}
