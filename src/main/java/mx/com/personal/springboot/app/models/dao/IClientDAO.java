package mx.com.personal.springboot.app.models.dao;

import java.util.List;

import mx.com.personal.springboot.app.models.entity.Cliente;

public interface IClientDAO {
	List<Cliente> findAll();
	void save(Cliente cliente);
	Cliente findOne(Long id);
	void delete(Long id);
}
