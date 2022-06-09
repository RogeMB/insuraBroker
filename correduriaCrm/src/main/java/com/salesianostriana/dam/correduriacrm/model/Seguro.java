package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguro {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSeguro;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;  

    private String tipo;

    private double cantidadAsegurada;

    private double precio;
    
    private String empresa;

    private String icono;
      
    // helpers
    public void addToCategoria(Categoria cat) { 
		this.setCategoria(cat);
		cat.getSeguros().add(this);
	}
	
	public void removeFromCategoria(Categoria cat) {
		this.setCategoria(cat);
		cat.getSeguros().remove(this);
	}

}