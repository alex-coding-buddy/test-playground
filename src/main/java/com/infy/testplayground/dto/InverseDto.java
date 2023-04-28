package com.infy.testplayground.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class InverseDto {
    private String w1;
    private String w2;
    private String r;
    private Inverse inverse;

    public enum Inverse {
        YES, NO
    }
}
