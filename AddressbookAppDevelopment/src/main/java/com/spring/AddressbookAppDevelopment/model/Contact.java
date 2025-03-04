package com.spring.AddressbookAppDevelopment.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public @Data class Contact {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
