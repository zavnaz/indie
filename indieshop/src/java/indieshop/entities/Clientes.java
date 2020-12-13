package indieshop.entities;
// Generated 12-13-2020 12:54:23 PM by Hibernate Tools 4.3.1


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
 * Clientes generated by hbm2java
 */
@Entity
@Table(name="clientes"
    ,catalog="indie_shop"
)
public class Clientes  implements java.io.Serializable {


     private String idCli;
     private Usuarios usuarios;
     private String dirCli;
     private String telCli;
     private String corCli;
     private Set<Valoracion> valoracions = new HashSet<Valoracion>(0);
     private Set<Facturacion> facturacions = new HashSet<Facturacion>(0);

    public Clientes() {
    }

	
    public Clientes(String idCli) {
        this.idCli = idCli;
    }
    public Clientes(String idCli, Usuarios usuarios, String dirCli, String telCli, String corCli, Set<Valoracion> valoracions, Set<Facturacion> facturacions) {
       this.idCli = idCli;
       this.usuarios = usuarios;
       this.dirCli = dirCli;
       this.telCli = telCli;
       this.corCli = corCli;
       this.valoracions = valoracions;
       this.facturacions = facturacions;
    }
   
     @Id 

    
    @Column(name="id_cli", unique=true, nullable=false, length=10)
    public String getIdCli() {
        return this.idCli;
    }
    
    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_us")
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    
    @Column(name="dir_cli", length=100)
    public String getDirCli() {
        return this.dirCli;
    }
    
    public void setDirCli(String dirCli) {
        this.dirCli = dirCli;
    }

    
    @Column(name="tel_cli", length=15)
    public String getTelCli() {
        return this.telCli;
    }
    
    public void setTelCli(String telCli) {
        this.telCli = telCli;
    }

    
    @Column(name="cor_cli", length=50)
    public String getCorCli() {
        return this.corCli;
    }
    
    public void setCorCli(String corCli) {
        this.corCli = corCli;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
    public Set<Valoracion> getValoracions() {
        return this.valoracions;
    }
    
    public void setValoracions(Set<Valoracion> valoracions) {
        this.valoracions = valoracions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
    public Set<Facturacion> getFacturacions() {
        return this.facturacions;
    }
    
    public void setFacturacions(Set<Facturacion> facturacions) {
        this.facturacions = facturacions;
    }




}


