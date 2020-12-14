/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Facturacion;
import indieshop.model.FacturacionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mario
 */
@Controller
     
@RequestMapping("facturacion")
public class FacturacionController {
    
    FacturacionModel factura = new FacturacionModel();

    
    @RequestMapping("fac")
    public String listarFactura(Model model) {
        model.addAttribute("lf", factura.listarFactura());
       
        return "facturacion/listar";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoFactura(Model model) {

         model.addAttribute("factura", new Facturacion());
        return "facturacion/nuevo";
    }
    
    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarFactura(@ModelAttribute("factura") Facturacion fac, Model model, RedirectAttributes atributos) {
        if (factura.insertarFactura(fac) > 0) {
            atributos.addFlashAttribute("exito", "Factura registrado exitosamente");
            return "redirect:/facturacion/fac";
        } else {
            model.addAttribute("lf", factura.listarFactura());
            model.addAttribute("factura", fac);
                       return "facturacion/nuevo";

        }
    }
    
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerFactura(@PathVariable("codigo") String codigo, Model model)
         {
             //agregar lista de productos
             model.addAttribute("factura", factura.obtenerFactura(codigo));
             
             return "facturacion/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarFactura(Facturacion fac, Model model, RedirectAttributes atributos){
             
             if (factura.modificarFactura(fac)>0)
             {
                 atributos.addFlashAttribute("exito", "producto modificada con exito");
                 return "redirect:/facturacion/fac";
             }
             else
             {
                 model.addAttribute("lf", factura.listarFactura());
                 model.addAttribute("factura", fac);
                 return "facturacion/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarFactura(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
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
         }
    
    
}
