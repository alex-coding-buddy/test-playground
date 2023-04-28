package com.infy.testplayground.controller;

import com.infy.testplayground.entity.Relation;
import com.infy.testplayground.repo.RelationRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relations")
public class RelationController extends AbstractCrudController<RelationRepository, Relation> {

}
