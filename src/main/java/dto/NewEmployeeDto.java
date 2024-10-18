package dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewEmployeeDto {
    int id;
    String fullName;
    LocalDateTime dateOfBirth;

    @Override
    public String toString() {
        return "[id=" + id + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + "]";
    }
}
