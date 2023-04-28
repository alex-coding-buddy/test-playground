package com.infy.testplayground.service;

import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.entity.Word;
import com.infy.testplayground.repo.RelationRepository;
import com.infy.testplayground.repo.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomRelationService implements RelationService {

    private final RelationRepository relationRepository;
    private final WordRepository wordRepository;

    @Override
    @Transactional
    public void createCustomRelation(RelationDto dto) {
        Word word1 = wordRepository.save(new Word()
                .setWord(dto.getW1()));
        Word word2 = wordRepository.save(new Word()
                .setWord(dto.getW2()));
        relationRepository.save(new Relation()
                .setRelation(Relation.RelationEnum.valueOf(dto.getR()))
                .setWord1(word1)
                .setWord2(word2));
    }
}
