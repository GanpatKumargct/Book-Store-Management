package com.BookStoreManagment.Repo;

import com.BookStoreManagment.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Book, Integer> {
}
