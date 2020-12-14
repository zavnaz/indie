/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.ProductosFactura;
import indieshop.model.ProdFacturaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mario
 */

@Controller
     
@RequestMapping("prodfactura")
public class ProdFacturaController {
    
    ProdFacturaModel pfactura = new ProdFacturaModel();

    
    @RequestMapping("prfac/{codigo}")
    public String listarPFactura(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos) 
    {
        model.addAttribute("lf", pfactura.listarProdFactura(codigo));
        return "facturacion/editar";
    }
    
    /*@RequestMapping("delete/{codigo}")
         public String eliminarPFactura(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (factura.eliminarFacturas(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "Factura eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/facturacion/fac";
         }*/
    
}
