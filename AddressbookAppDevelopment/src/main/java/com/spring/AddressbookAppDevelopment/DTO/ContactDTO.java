package com.spring.AddressbookAppDevelopment.DTO;

import lombok.Data;

public @Data class ContactDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public ContactDTO(String firstName, String email, String phone) {
    }
}
