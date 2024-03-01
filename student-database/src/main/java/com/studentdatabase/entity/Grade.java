package com.studentdatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Grade {
    @Id
    @Column(name = "pid")
    @Digits(integer = 7, fraction = 0, message = "PID must be a 7-digit number without preceding 0s")
    private Long PID;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int score;

    private String grade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    @JsonIgnore
    private Student student;

    // Constructors, getters, setters, and other methods
}
