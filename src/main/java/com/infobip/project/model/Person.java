package com.infobip.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "person")
    @Getter
    @Setter
    private List<Conversation> conversations;

    public Person(String phoneNumber, Long fundAmount) {
        this.phoneNumber = phoneNumber;
        this.fundAmount = fundAmount;
    }
}
