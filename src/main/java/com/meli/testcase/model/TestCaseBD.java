package com.meli.testcase.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "testCase")
public class TestCaseBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column(nullable = false)
    @NotNull(message = "The description of the testCase cannot be empty.")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "The quilates of the testCase cannot be empty.")
    private Boolean tested;

    @Column(nullable = false)
    @NotNull(message = "The passed of the testCase cannot be empty.")
    private Boolean passed;

    @Column(nullable = false)
    @NotNull(message = "The number_of_tries of the testCase cannot be empty.")
    private Integer number_of_tries;

    @Column(nullable = false)
    private LocalDateTime last_update;
}
