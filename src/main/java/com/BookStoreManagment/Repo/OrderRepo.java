package com.BookStoreManagment.Repo;

import com.BookStoreManagment.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
