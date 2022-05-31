package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany(mappedBy="categoria")
    private List<Seguros> seguros;
    
    public void addSeguro(Seguros seg) {
		this.seguros.add(seg);
		seg.setCategoria(this);
	}
	
	public void removeSeguro(Seguros seg) {
		this.seguros.remove(seg);
		seg.setCategoria(null);
	}

}