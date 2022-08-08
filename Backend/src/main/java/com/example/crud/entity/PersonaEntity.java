package com.example.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    @DateTimeFormat(pattern ="yyyy/mm/dd")
    private Date fechaNacimiento;
    private String contacto;


}
