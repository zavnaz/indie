/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.Facturacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.servlet.http.HttpSession;
import indieshop.entities.Clientes;

/**
 *
 * @author mario
 */
public class FacturacionModel 
{
     
    SessionFactory factory = HibernateUtil.getSessionFactory();
     
    public Facturacion insertarFactura(Clientes cl) {
        
        Facturacion fac= new Facturacion();
        int i;
        Session ses = factory.openSession();
        
        try {
            //Query con = ses.createQuery("SELECT a FROM Facturacion a where clientes.idCli='"+cl.getIdCli()+"' order by idFac desc");
            Query consulta = ses.createQuery("SELECT a FROM Facturacion a where clientes.idCli='"+cl.getIdCli()+"' order by idFac desc");
            List<Facturacion> lista = consulta.list();
            if(lista.get(0).getPagada()==Boolean.TRUE)
            {
            i= Integer.parseInt(lista.get(0).getIdFac());
            i++;
            fac.setIdFac(Integer.toString(i));
            fac.setClientes(cl);
            fac.setTotFac(0.0);
            fac.setPagada(Boolean.FALSE);
            
            Transaction tran = ses.beginTransaction();
            ses.save(fac);
            tran.commit();
            ses.close();
            return fac;
            }
            else
            {
                return lista.get(0);
            }
            
        } catch (Exception e) {
            ses.close();
            return null;
        }
    } 
    
    public int modificarFactura(Facturacion fac) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(fac);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    
    public int eliminarFacturas(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Facturacion fac = (Facturacion) ses.get(Facturacion.class, id);
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
    
    public Facturacion obtenerFactura(String codigo) {
        Session ses = factory.openSession();
        try {
            Facturacion fac = (Facturacion) ses.get(Facturacion.class, codigo);
            
            ses.close();
            return fac;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public List<Facturacion> listarFactura() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Facturacion a");
            List<Facturacion> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
}
