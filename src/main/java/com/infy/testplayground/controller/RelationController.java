package com.infy.testplayground.controller;

import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.repo.RelationRepository;
import com.infy.testplayground.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relations")
@RequiredArgsConstructor
public class RelationController extends AbstractCrudController<RelationRepository, Relation> {

    private final RelationService relationService;

    @PostMapping("/task1")
    public HttpStatus createCustom(@RequestBody RelationDto dto) {
        relationService.createCustomRelation(dto);
        return HttpStatus.CREATED;
    }

}
