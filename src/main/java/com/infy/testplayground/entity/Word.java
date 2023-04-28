package com.infy.testplayground.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "words")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Word extends H2Entity {

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "relation")
//    @JsonManagedReference
//    private Set<Relation> relations;

    public Word(long id) {
        super(id);
    }

    @Column(nullable = false)
    private String word;
}
