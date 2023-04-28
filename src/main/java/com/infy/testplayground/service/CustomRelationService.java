package com.infy.testplayground.service;

import com.infy.testplayground.dto.InverseDto;
import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.entity.Word;
import com.infy.testplayground.repo.RelationRepository;
import com.infy.testplayground.repo.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.infy.testplayground.dto.InverseDto.Inverse.NO;
import static com.infy.testplayground.dto.InverseDto.Inverse.YES;
import static java.util.stream.Collectors.toList;

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

    @Override
    public Collection<Relation> filterByType(Relation.RelationEnum relationType) {
        return relationRepository.findByRelation(relationType);
    }

    @Override
    public Collection<String> getInverse() {
//        Stream<InverseDto> notInverseDtoStream = StreamSupport.stream(relationRepository.findAll().spliterator(), false)
//                .map(entity -> new InverseDto()
//                        .setW1(entity.getWord1().getWord())
//                        .setW2(entity.getWord2().getWord())
//                        .setR(entity.getRelation().name())
//                        .setInverse(NO));
//        Stream<InverseDto> inverseDtoStream = StreamSupport.stream(relationRepository.findAll().spliterator(), false)
//                .map(entity -> new InverseDto()
//                        .setW1(entity.getWord2().getWord())
//                        .setW2(entity.getWord1().getWord())
//                        .setR(entity.getRelation().name())
//                        .setInverse(YES));
//
        Stream<String> notInverseDtoStream = StreamSupport.stream(relationRepository.findAll().spliterator(), false)
                .map(entity -> String.join(" ", entity.getWord1().getWord(),
                                entity.getWord2().getWord(),
                                entity.getRelation().name(),
                                NO.name()
                ));
        Stream<String> inverseDtoStream = StreamSupport.stream(relationRepository.findAll().spliterator(), false)
                .map(entity -> String.join(" ", entity.getWord2().getWord(),
                        entity.getWord1().getWord(),
                        entity.getRelation().name(),
                        YES.name()
                ));

        return Stream.concat(notInverseDtoStream, inverseDtoStream).collect(toList());

    }
}
