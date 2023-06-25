package com.infobip.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private Long fundAmount;
}
