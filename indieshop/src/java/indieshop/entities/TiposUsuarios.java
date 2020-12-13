package indieshop.entities;
// Generated 12-12-2020 04:09:12 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TiposUsuarios generated by hbm2java
 */
@Entity
@Table(name="tipos_usuarios"
    ,catalog="indie_shop"
)
public class TiposUsuarios  implements java.io.Serializable {


     private String idTu;
     private String rolTu;

    public TiposUsuarios() {
    }

	
    public TiposUsuarios(String idTu) {
        this.idTu = idTu;
    }
    public TiposUsuarios(String idTu, String rolTu) {
       this.idTu = idTu;
       this.rolTu = rolTu;
    }
   
     @Id 

    
    @Column(name="id_tu", unique=true, nullable=false, length=10)
    public String getIdTu() {
        return this.idTu;
    }
    
    public void setIdTu(String idTu) {
        this.idTu = idTu;
    }

    
    @Column(name="rol_tu", length=50)
    public String getRolTu() {
        return this.rolTu;
    }
    
    public void setRolTu(String rolTu) {
        this.rolTu = rolTu;
    }




}

