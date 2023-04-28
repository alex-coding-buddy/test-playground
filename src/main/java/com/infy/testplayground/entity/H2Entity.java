package com.infy.testplayground.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class H2Entity {

    @Id
    @GeneratedValue
    private Long id;
}
