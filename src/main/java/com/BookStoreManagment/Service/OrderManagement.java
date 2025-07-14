package com.BookStoreManagment.Service;


import com.BookStoreManagment.Entity.Book;
import com.BookStoreManagment.Entity.Order;
import com.BookStoreManagment.Entity.OrderRequest;
import com.BookStoreManagment.Entity.User;
import com.BookStoreManagment.Repo.OrderRepo;
import com.BookStoreManagment.Repo.UserRepo;
import com.BookStoreManagment.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderManagement {
    @Autowired
    private UserRepo userRepo;          //User
    @Autowired
    private UserRepository userRepository;   //Book
    @Autowired
    private OrderRepo orderRepo;



    /**
     The idea is:
     A user places an order
     It contains a list of books (with quantity)
     We:
     Validate user
     Check books and stock
     Deduct stock
     Calculate total price
     Save the order
     Return confirmation

     Steps to do
     Check if user exists
     Loop through book list
     Check stock, subtract quantity
     Save order and return confirmation
     */
    public String placeorder(OrderRequest orderRequest){
        //1. FInd the User
        Optional<User> userExist = userRepo.findById(orderRequest.getUserId());
        if (!userExist.isPresent()){
            System.out.println("User doesn't exist");
        }
        User user = userExist.get();

        //2. Prepare for store order book
        List<Book> orderBook = new ArrayList<>();
        double totalprice = 0.0;

        //3.Loops through requested book
        for (OrderRequest.BookOrderEntry bq:orderRequest.getBooks()) {
            Optional<Book> optionalBook = userRepository.findById(bq.getBookId());
            if(!optionalBook.isPresent()){
                return "Book with ID " + bq.getBookId() + " not found.";
            }


            //Agar stock se jayada quantity ka order aa jaye tb
            Book book = optionalBook.get();
            if(book.getStockQuantity()< bq.getQuantity()){
                return "Insufficient stock for: " + book.getTitle();
            }

            //agar jitna order aaya hai usese jayda hai to usko dekar stock me se ghata do
            book.setStockQuantity(book.getStockQuantity()- bq.getQuantity());
            userRepository.save(book);

            //Add to the order
            orderBook.add(book);

            //total price
            totalprice +=book.getPrice()* bq.getQuantity();

        }
        //4. Create order list
        Order order = new Order();
        order.setUser(user);
        order.setBooks(orderBook);
        order.setTotalPrice(totalprice);
        order.setStatus("Pending");
        order.setPayment("unpaid");

        //5. Save Order
        orderRepo.save(order);


        //6. Return Succes
        return "order place successfully, Total Price "+totalprice+"/ only";
    }


    //Get all order detail by admin only
    public List<Order> getAllOrders() {

        return orderRepo.findAll();
    }


    //Get order detail by its id
    public Order getOrderById(int id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

    }

    //update order status by admin
    public String updateOrderStatus(int id, String newStatus) {
        Optional<Order> optionalOrder = orderRepo.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newStatus);
            orderRepo.save(order);
            return "Order status updated to: " + newStatus;
        } else {
            return "Order not found with ID: " + id;
        }
    }

}
