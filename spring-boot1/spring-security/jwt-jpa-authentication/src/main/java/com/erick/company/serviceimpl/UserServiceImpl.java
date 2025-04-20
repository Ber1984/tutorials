package com.erick.company.serviceimpl;

import com.erick.company.model.User;
import com.erick.company.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> getUserByPublishedOn(String publishedOn) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
