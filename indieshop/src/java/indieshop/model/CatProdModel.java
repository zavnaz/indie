/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.CategoriaProductos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author roco_
 */
public class CatProdModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
      public int insertarCatProd(CategoriaProductos catprod) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(catprod);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarCatProd(CategoriaProductos catprod) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(catprod);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarCatProd(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            CategoriaProductos catprod = (CategoriaProductos) ses.get(CategoriaProductos.class, id);
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
    public CategoriaProductos obtenerCatProd(String codigo) {
        Session ses = factory.openSession();
        try {
            CategoriaProductos catprod = (CategoriaProductos) ses.get(CategoriaProductos.class, codigo);
            
            ses.close();
            return catprod;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

  
    public List<CategoriaProductos> listarCategoriaProductos() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM categoria_productos a");
            List<CategoriaProductos> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    
}
