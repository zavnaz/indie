/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.CategoriaProductos;
import indieshop.entities.Clientes;

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
     public int insertarCatProd(CategoriaProductos clie) {
        Session ses = factory.openSession();
        try { 
            Query consulta = ses.createQuery("SELECT a FROM CategoriaProductos a order by idCat desc");
            List<CategoriaProductos> lista = consulta.list();
            int i= Integer.parseInt(lista.get(0).getIdCat());
            i++;
            clie.setIdCat(Integer.toString(i));
            Transaction tran = ses.beginTransaction();
            ses.save(clie);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarCatProd(CategoriaProductos clie) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(clie);
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
            CategoriaProductos cliente = (CategoriaProductos) ses.get(CategoriaProductos.class, id);
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
    public CategoriaProductos obtenerCatProd(String codigo) {
        Session ses = factory.openSession();
        try {
            CategoriaProductos clie = (CategoriaProductos) ses.get(CategoriaProductos.class, codigo);
            
            ses.close();
            return clie;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    public List<CategoriaProductos> listarCatProd() {
        Session ses = factory.openSession();
        try {
            Query cat = ses.createQuery("SELECT cat FROM CategoriaProductos cat");
            List<CategoriaProductos> lista = cat.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
}