package com.spring.AddressbookAppDevelopment.DTO;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public @Data class ContactDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
