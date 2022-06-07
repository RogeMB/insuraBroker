package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @OneToMany(mappedBy="idCategoria", fetch = FetchType.EAGER)  // qué hacía esto exactamente?
    private List<Seguros> listaSeguros;
    
    // helpers
    public void addSeguro(Seguros seg) {  //van aquí estos helpers? 
		this.listaSeguros.add(seg);
		seg.setIdCategoria(this);
	}
	
	public void removeSeguro(Seguros seg) {
		this.listaSeguros.remove(seg);
		seg.setIdCategoria(null);
	}

}