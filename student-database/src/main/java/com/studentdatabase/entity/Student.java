package com.studentdatabase.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @Column(name = "pid", nullable = false, unique = true)
    @Digits(integer = 7, fraction = 0, message = "PID must be a 7-digit number without preceding 0s")
    private Long PID;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*$")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*[.]?$")
    private String lastName;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Grade gradeScore;

    // Constructors, getters, setters, and other methods
}
