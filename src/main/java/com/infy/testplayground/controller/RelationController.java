package com.infy.testplayground.controller;

import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.repo.RelationRepository;
import com.infy.testplayground.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @GetMapping("/filter")
    public Collection<Relation> getFiltered(@RequestParam String relationType) {
        return relationService.filterByType(Relation.RelationEnum.valueOf(relationType));
    }
}
