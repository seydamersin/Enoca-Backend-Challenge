package com.seyda.repository.entity;

import com.seyda.repository.enums.Titles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Titles title;

    private String email;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false, referencedColumnName = "id")
    private Company company;
}

