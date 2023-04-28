package com.infy.testplayground.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RelationDto {

    @Pattern(regexp="^[a-zA-Z]",message="User-friendly message")
    private String w1;
    @Pattern(regexp="^[a-zA-Z]",message="User-friendly message")
    private String w2;
    private String r;
}
