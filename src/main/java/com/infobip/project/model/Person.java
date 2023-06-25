package com.infobip.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private Long fundAmount;
}
