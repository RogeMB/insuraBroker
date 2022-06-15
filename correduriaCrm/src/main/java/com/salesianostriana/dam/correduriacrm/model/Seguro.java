package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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
  
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy="seguro", fetch = FetchType.EAGER, cascade=javax.persistence.CascadeType.REMOVE, orphanRemoval = true)
//    @Builder.Default
//    private List<Venta> ventas = new ArrayList <> ();
    
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