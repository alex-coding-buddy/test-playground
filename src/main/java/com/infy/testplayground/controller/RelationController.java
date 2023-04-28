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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.infy.testplayground.dto.InverseDto.Inverse.NO;

@RestController
@RequestMapping("relations")
@RequiredArgsConstructor
public class RelationController extends AbstractCrudController<RelationRepository, Relation> {

    private final RelationService relationService;

    @PostMapping("/task1")
    public HttpStatus createCustom(@RequestBody /*@Valid*/ RelationDto dto) {
        // TDOD: move to annotations
        validateWord(dto.getW1());
        validateWord(dto.getW2());
        relationService.createCustomRelation(dto);
        return HttpStatus.CREATED;
    }

    public static void validateWord(String word){
        Matcher m = Pattern.compile("^\\b(?:\\w|-)+\\b$").matcher(word); // todo check pattern
        if(m.matches()) {
            throw new RuntimeException("User-friendly error");
        }
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
