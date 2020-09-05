package com.microservices.unittest.data;

import com.microservices.unittest.contoller.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
