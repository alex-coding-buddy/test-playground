package com.infy.testplayground.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;


@Entity(name = "users")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class User extends H2Entity {

    private String name;

}
