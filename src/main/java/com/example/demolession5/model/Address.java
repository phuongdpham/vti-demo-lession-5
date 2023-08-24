package com.example.demolession5.model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String street;
    String city;

    public static void main(String[] args) {
        var address = new Address();
        address.setCity("Hanoi");
        address.setStreet("Nguyen Trai");

        log.info("this is address with normal constructor {}", address);

        // create address with builder
        var address2 = Address.builder()
                .city("Hanoi")
                .street("Nguyen Trai")
                .build();

        log.info("with builder {}", address2);

        // create address with accessors
        var address3 = new Address()
                .setCity("Hanoi")
                .setStreet("Nguyen Trai");

        log.info("with accessors chain {}", address3);
        log.warn("this is warning {}, {}", address, address2);
        log.error("this is error", new RuntimeException("this is exception"));
    }
}
