package ru.vkarikov.validation.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Customer {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "INN is mandatory")
    private String inn;
}
