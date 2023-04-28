package com.infy.testplayground.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "relations")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Relation extends H2Entity {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "word1_id")
    private Word word1;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "word2_id")
    private Word word2;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RelationEnum relation;

    public enum RelationEnum {
        SYNONYM, ANTONYM, RELATED;
    }
}
