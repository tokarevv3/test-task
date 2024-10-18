package entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewEmployee {
    int id;
    String fullName;
    LocalDateTime dateOfBirth;
    String department;
    int salary;
}
