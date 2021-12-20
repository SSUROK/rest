package ru.gb.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.rest.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

}
