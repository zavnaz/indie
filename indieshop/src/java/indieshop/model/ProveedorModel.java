/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.Proveedores;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mario
 */
public class ProveedorModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
      public int insertarProveedor(Proveedores proveedor) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(proveedor);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarProveedor(Proveedores proveedor) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(proveedor);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarProveedor(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Proveedores catprod = (Proveedores) ses.get(Proveedores.class, id);
            if (catprod != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(catprod);
                tran.commit();
                filasAfectadas = 1;
            }
            ses.close();
            return filasAfectadas;
        } catch (Exception e) {
            ses.close();
            return filasAfectadas;
        }
    }
    public Proveedores obtenerProveedor(String codigo) {
        Session ses = factory.openSession();
        try {
            Proveedores proveedor = (Proveedores) ses.get(Proveedores.class, codigo);
            
            ses.close();
            return proveedor;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

  
    public List<Proveedores> listarProveedor() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Proveedores a");
            List<Proveedores> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
}
