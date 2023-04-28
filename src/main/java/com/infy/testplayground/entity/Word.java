package com.infy.testplayground.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "words")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Word extends H2Entity {
//    @OneToMany(mappedBy = "relation")
//    private Set<Relation> relations;

    public Word(long id) {
        super(id);
    }

    @Column(nullable = false)
    private String word;
}
