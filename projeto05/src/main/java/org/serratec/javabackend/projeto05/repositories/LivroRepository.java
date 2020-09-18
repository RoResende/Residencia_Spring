package org.serratec.javabackend.projeto05.repositories;

import org.serratec.javabackend.projeto05.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	

}
