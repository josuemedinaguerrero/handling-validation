package com.exceptions.ValidHandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

  @NotNull(message = "User name should not be null")
  private String name;

  @NotNull(message = "Address should not be null")
  private String address;

  @Email(message = "This is not a correct email")
  private String email;

  @Min(value = 23, message = "Age is less than 23")
  @Max(value = 60, message = "Age is more than 60")
  private int age;

  private double salary;

}
