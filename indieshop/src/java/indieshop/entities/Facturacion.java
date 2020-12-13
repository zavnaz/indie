package indieshop.entities;
// Generated 12-12-2020 04:09:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Facturacion generated by hbm2java
 */
@Entity
@Table(name="facturacion"
    ,catalog="indie_shop"
)
public class Facturacion  implements java.io.Serializable {


     private String idFac;
     private Clientes clientes;
     private Double totFac;
     private Set<ProductosFactura> productosFacturas = new HashSet<ProductosFactura>(0);

    public Facturacion() {
    }

	
    public Facturacion(String idFac) {
        this.idFac = idFac;
    }
    public Facturacion(String idFac, Clientes clientes, Double totFac, Set<ProductosFactura> productosFacturas) {
       this.idFac = idFac;
       this.clientes = clientes;
       this.totFac = totFac;
       this.productosFacturas = productosFacturas;
    }
   
     @Id 

    
    @Column(name="id_fac", unique=true, nullable=false, length=10)
    public String getIdFac() {
        return this.idFac;
    }
    
    public void setIdFac(String idFac) {
        this.idFac = idFac;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_cli")
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    
    @Column(name="tot_fac", precision=22, scale=0)
    public Double getTotFac() {
        return this.totFac;
    }
    
    public void setTotFac(Double totFac) {
        this.totFac = totFac;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facturacion")
    public Set<ProductosFactura> getProductosFacturas() {
        return this.productosFacturas;
    }
    
    public void setProductosFacturas(Set<ProductosFactura> productosFacturas) {
        this.productosFacturas = productosFacturas;
    }




}

