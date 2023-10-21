package com.inverntoryservice.InventroyService.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventroyRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItem(String item);


    List<Inventory> findByItemIn(List<String> item);
}
