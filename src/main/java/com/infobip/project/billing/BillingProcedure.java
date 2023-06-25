package com.infobip.project.billing;

import com.infobip.project.model.Person;
import com.infobip.project.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class BillingProcedure {
    private static final int CONVERSATION_PRICE = 20;


    private final PersonRepository personRepository;

    public BillingProcedure(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public boolean userHasFunds(Person person) {

            return person.getFundAmount() >= CONVERSATION_PRICE;

    }

    public ChargedUserStatus chargeUser(Person sender) {

            sender.setFundAmount(sender.getFundAmount() - CONVERSATION_PRICE);
            Person savedPerson = personRepository.save(sender);

            if(savedPerson != null) {
                return ChargedUserStatus.SUCCESS;
            } else {
                return ChargedUserStatus.FAILURE;
            }
    }
}
