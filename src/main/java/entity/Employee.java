package entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Employee {
    int id;
    String firstName;
    String lastName;
    LocalDateTime dateOfBirth;
    String department;
    int salary;

}
