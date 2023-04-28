package com.infy.testplayground.controller;

import com.infy.testplayground.dto.InverseDto;
import com.infy.testplayground.dto.RelationDto;
import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.repo.RelationRepository;
import com.infy.testplayground.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Collection;

import static com.infy.testplayground.dto.InverseDto.Inverse.NO;

@RestController
@RequestMapping("relations")
@RequiredArgsConstructor
public class RelationController extends AbstractCrudController<RelationRepository, Relation> {

    private final RelationService relationService;

    @PostMapping("/task1")
    public HttpStatus createCustom(@RequestBody @Valid RelationDto dto) {
        relationService.createCustomRelation(dto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/filter")
    public Collection<Relation> getFiltered(@RequestParam String relationType) {
        return relationService.filterByType(Relation.RelationEnum.valueOf(relationType));
    }

    @GetMapping("/inverse")
    public Collection<?> getInversed() {
        return relationService.getInverse();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
