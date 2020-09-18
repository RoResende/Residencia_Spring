package org.serratec.javabackend.projetofinal.repositories;

import org.serratec.javabackend.projetofinal.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
