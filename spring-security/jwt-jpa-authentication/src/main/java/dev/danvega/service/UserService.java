package dev.danvega.service;

import dev.danvega.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(int id);

    List<User> findAll();

    Optional<User> getUserByPublishedOn(String publishedOn);

    void save(User user);

    int delete(User user);

}
