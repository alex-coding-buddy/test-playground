package com.infy.testplayground.repo;

import com.infy.testplayground.entity.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
}
