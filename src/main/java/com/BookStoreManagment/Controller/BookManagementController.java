package com.BookStoreManagment.Controller;

import com.BookStoreManagment.Entity.Book;
import com.BookStoreManagment.Service.BookManagent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookManagementController {
    @Autowired
    private BookManagent bookManagent;

    @GetMapping("/books")
    public List<Book> GetALlBook(){
        return bookManagent.getAllBook();
    }

    @GetMapping("/bookid")
    public Book GetBookByID(@RequestParam int id){
        Book bookById = bookManagent.getBookById(id);
        return bookById;
    }

    @PostMapping("/addbook")
    public Book AddBook(@RequestBody Book book){
        return  bookManagent.SaveBook(book);
    }

    @PutMapping("/Updatedbook/{id}")
    public Book UpdateBook(@PathVariable int id, @RequestBody Book book){
        Book updatedBook = bookManagent.UpdateBook(id, book);
        return updatedBook;
    }

    @PostMapping("/delete")
    public void deletebook(@RequestParam int id){
        bookManagent.DeleteBook(id);
        System.out.println("Book Deleted successfully");
    }

}
