package com.BookStoreManagment.Service;

import com.BookStoreManagment.Entity.Book;
import com.BookStoreManagment.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class BookManagent {
    @Autowired
    UserRepository userRepository;

    //Get All Book
    public List<Book> getAllBook(){
        List<Book> bookList = userRepository.findAll();
        return bookList;
    }
    
    //Get Book By iD
     public Book getBookById(int id){
         Optional<Book> byId = userRepository.findById(id);
         Book book = byId.get();
         return book;
     }

     //Save Books
    public Book SaveBook(Book book){
        Book save = userRepository.save(book);
        return save;
    }

    //Update existing book by id.
    public Book UpdateBook(Integer id, Book updatedBook){
        // Step 1: Try to find the existing book by ID
        Optional<Book> optionalBook = userRepository.findById(id);

        // Step 2: Check if the book exists
        if (optionalBook.isPresent()) {
            // Step 3: Get the book from Optional
            Book existingBook = optionalBook.get();

            // Step 4: Update its fields
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenere(updatedBook.getGenere());
            existingBook.setISBN(updatedBook.getISBN());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setStockQuantity(updatedBook.getStockQuantity());
            existingBook.setImageUrl(updatedBook.getImageUrl());

            // Step 5: Save the updated book
            return userRepository.save(existingBook);

        } else {
            // Step 6: Book not found
            System.out.println("Book with ID " + id + " not found.");
            return null; // or you can throw an exception if you learn that later
        }
    }

    //Delete book by id
    public void DeleteBook(int id){
        userRepository.deleteById(id);
    }
}
