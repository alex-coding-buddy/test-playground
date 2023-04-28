package com.infy.testplayground.service;

import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface RelationService {
    void createCustomRelation(RelationDto dto);

    Collection<Relation> filterByType(Relation.RelationEnum relationType);
}
