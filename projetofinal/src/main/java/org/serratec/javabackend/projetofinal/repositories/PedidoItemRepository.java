package org.serratec.javabackend.projetofinal.repositories;

import org.serratec.javabackend.projetofinal.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {

}
