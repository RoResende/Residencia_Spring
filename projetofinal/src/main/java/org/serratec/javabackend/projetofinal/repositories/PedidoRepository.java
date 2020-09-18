package org.serratec.javabackend.projetofinal.repositories;

import org.serratec.javabackend.projetofinal.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
