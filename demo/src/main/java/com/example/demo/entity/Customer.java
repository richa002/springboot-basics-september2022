package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    long customerId;
    @NotBlank
    String user_name;
    @NotBlank(message = "First Name is mandatory")
    String firstName;
    String lastName;
    @Email
    String email;
    String phone;
    @Min(5)
    String password;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    CustAdr custAdr;
}
