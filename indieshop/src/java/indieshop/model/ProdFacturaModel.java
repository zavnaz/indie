/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.ProductosFactura;
import indieshop.entities.Productos;
import indieshop.entities.Facturacion;
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
     
    public int insertarProdFactura(Facturacion idf,Productos idp)//ProductosFactura fac
    {
        ProductosFactura fac=new ProductosFactura();
        FacturacionModel mfac= new FacturacionModel();
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM ProductosFactura a order by idPfac desc");
            List<ProductosFactura> lista = consulta.list();
            int i= Integer.parseInt(lista.get(0).getIdPfac());
            i++;
            fac.setIdPfac(Integer.toString(i));
            fac.setFacturacion(idf);
            fac.setProductos(idp);
            fac.setCantidadPfac(1);
            fac.setTotPfac(idp.getPrecioPro());
            idf.setTotFac(idf.getTotFac()+idp.getPrecioPro());
            int n= mfac.modificarFactura(idf);
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
