package com.salesianostriana.dam.correduriacrm.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
//  @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "cliente_sequence"
    )
    private long idCliente;

    private String nombre;

    private String apellidos;

    private String dni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private String telefono;

    private String email;
    
    private String genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    private boolean esPremium;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Venta> ventas = new ArrayList <> ();
    
}