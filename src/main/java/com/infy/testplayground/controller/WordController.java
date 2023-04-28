package com.infy.testplayground.controller;

import com.infy.testplayground.entity.Word;
import com.infy.testplayground.repo.WordRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("words")
public class WordController extends AbstractCrudController<WordRepository, Word> {



}
