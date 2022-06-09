package com.salesianostriana.dam.correduriacrm.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategoria;
    
    private String nombre;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)  
    @Builder.Default
    private List<Seguro> seguros = new ArrayList <> ();


}