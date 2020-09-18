package org.serratec.javabackend.projetofinal.repositories;

import org.serratec.javabackend.projetofinal.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
