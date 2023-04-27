package com.infy.testplayground.repo;

import com.infy.testplayground.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
