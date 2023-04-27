package com.infy.testplayground.controller;

import com.infy.testplayground.entity.User;
import com.infy.testplayground.repo.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends AbstractCrudController<UserRepository, User> {

}
