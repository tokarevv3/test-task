package entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewEmployee {
    String firstName;
    Long count;
}
