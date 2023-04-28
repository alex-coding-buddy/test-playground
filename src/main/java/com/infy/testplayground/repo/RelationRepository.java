package com.infy.testplayground.repo;

import com.infy.testplayground.entity.Relation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelationRepository extends CrudRepository<Relation, Long> {
    List<Relation> findByRelation(Relation.RelationEnum relationEnum);
}
