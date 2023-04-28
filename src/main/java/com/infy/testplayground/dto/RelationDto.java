package com.infy.testplayground.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RelationDto {
    private String w1;
    private String w2;
    private String r;
}
