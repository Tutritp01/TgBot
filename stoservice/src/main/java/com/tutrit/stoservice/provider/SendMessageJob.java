package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.repository.UserRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.util.stream.Stream;

public class SendMessageJob {

    private UserRepository userRepository;

    private Clock clock;

    public void process(LocalDate eventDate) {
        if (eventDate.isBefore(LocalDate.now(clock))) {
            Stream.of(userRepository.findAll())
                    .forEach(System.out::println);
        }
    }
}
