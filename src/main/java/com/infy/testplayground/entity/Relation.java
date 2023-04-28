package com.infy.testplayground.entity;

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
    @JoinColumn(name = "word1_id")
    private Word word1Id;

    @ManyToOne
    @JoinColumn(name = "word2_id")
    private Word word2Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RelationEnum relation;

    enum RelationEnum {
        SYNONYM, ANTONYM, RELATED;
    }
}
