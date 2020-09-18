package org.serratec.javabackend.projeto04.repository;

import org.serratec.javabackend.projeto04.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	

}
