package com.tburakonat.runnerz.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

// This is another way of building a HttpClient Class where you don't have to write the methods yourself
// You have to create a UserHttpClient in the Main Application Class though because this is just the interface
public interface UserHttpClient {

    @GetExchange("/users")
    List<User> findAll();

    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);
}
