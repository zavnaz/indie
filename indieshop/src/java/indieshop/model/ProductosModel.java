/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.Productos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mario
 */
public class ProductosModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
      public int insertarProductos(Productos pro) {
        Session ses = factory.openSession();
        String a = pro.getNomPro();        
        pro.setImgPro(a);
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(pro);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
      
      public int modificarProductos(Productos pro) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(pro);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarProductos(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Productos cliente = (Productos) ses.get(Productos.class, id);
            if (cliente != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(cliente);
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
    
    public Productos obtenerProductos(String codigo) {
        Session ses = factory.openSession();
        try {
            Productos clie = (Productos) ses.get(Productos.class, codigo);
            
            ses.close();
            return clie;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public List<Productos> listarProductos() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Productos a");
            List<Productos> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
}
