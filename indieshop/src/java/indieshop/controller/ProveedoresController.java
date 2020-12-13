/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Proveedores;
import indieshop.model.ProveedorModel;
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
 
 @RequestMapping("proveedor")
public class ProveedoresController {
     
     ProveedorModel proveedor = new ProveedorModel();

    @RequestMapping("prov")
    public String listarProveedor(Model model) {
        model.addAttribute("lp", proveedor.listarProveedor());
      
        return "proveedor/listar";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoProveedor(Model model) {
         model.addAttribute("proveedor", new Proveedores());
        return "proveedor/nuevo";
    }
    
    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarProveedor(@ModelAttribute("proveedor") Proveedores prov, Model model, RedirectAttributes atributos) {
        prov.setNumVenProv(0);
        if (proveedor.insertarProveedor(prov) > 0) {
            atributos.addFlashAttribute("exito", "Proveedor registrado exitosamente");
            return "redirect:/proveedor/prov";
        } else {
            model.addAttribute("listarProveedor", proveedor.listarProveedor());
            model.addAttribute("Catprod", prov);
                       return "proveedor/nuevo";

        }
    }
    
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerProveedor(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("proveedor", proveedor.obtenerProveedor(codigo));
             
             return "proveedor/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarProveedor(Proveedores prov, Model model, RedirectAttributes atributos){
             
             if (proveedor.modificarProveedor(prov)>0)
             {
                 atributos.addFlashAttribute("exito", "Proveedor modificada con exito");
                 return "redirect:/proveedor/prov";
             }
             else
             {
                 model.addAttribute("listarProveedor", proveedor.listarProveedor());
                 model.addAttribute("proveedor", prov);
                 return "proveedor/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarProveedor(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (proveedor.eliminarProveedor(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "Proveedor eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/proveedor/prov";
         }
    
}
