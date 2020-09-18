package org.serratec.javabackend.projetofinal.repositories;

import java.util.List;

import org.serratec.javabackend.projetofinal.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
	
	List<Cliente> findBynomeUsuario(String nomeUsuario);
	
}
