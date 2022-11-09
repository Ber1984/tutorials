package com.demo.compatablefuture.repository;

import com.demo.compatablefuture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
