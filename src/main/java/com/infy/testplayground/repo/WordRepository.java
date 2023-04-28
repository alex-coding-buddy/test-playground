package com.infy.testplayground.repo;

import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.entity.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordRepository extends CrudRepository<Word, Long> {

    List<Word> findByWord(String word);
}
