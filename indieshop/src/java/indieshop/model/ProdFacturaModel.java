/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.ProductosFactura;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mario
 */
public class ProdFacturaModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
     
    public int insertarProdFactura(ProductosFactura fac) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(fac);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    } 
    
    
    public int eliminarProdFacturas(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            ProductosFactura fac = (ProductosFactura) ses.get(ProductosFactura.class, id);
            if (fac != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(fac);
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


    public List<ProductosFactura> listarProdFactura(String id) {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM ProductosFactura a where facturacion.idFac="+id);
            List<ProductosFactura> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
}
