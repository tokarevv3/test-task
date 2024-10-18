package dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class EmployeeDto {
    int id;
    String firstName;
    String lastName;
    LocalDateTime dateOfBirth;

    @Override
    public String toString() {
        return "[id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
    }
}
