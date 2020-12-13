/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.CategoriaProductos;
import indieshop.entities.Clientes;
import indieshop.model.CatProdModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roco_
 */
 @Controller
     
@RequestMapping("catprod")
public class CatProdController {
    CatProdModel catprod = new CatProdModel();

    @RequestMapping("cat")
    public String listarCatProd(Model model) {
        model.addAttribute("listarCatProd", catprod.listarCategoriaProductos());
      
        return "catprod/listar";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoCatProd(Model model) {
         model.addAttribute("catprod", new CategoriaProductos());
        return "catprod/nuevo";
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarCatProd(@ModelAttribute("Catprod") CategoriaProductos cat, Model model, RedirectAttributes atributos) {
        if (catprod.insertarCatProd(cat) > 0) {
            atributos.addFlashAttribute("exito", "Cliente registrado exitosamente");
            return "redirect:/catprod/cat";
        } else {
            model.addAttribute("listarCatProd", catprod.listarCategoriaProductos());
            model.addAttribute("Catprod", cat);
                       return "catprod/nuevo";

        }
    }
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerCatProd(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("catprod", catprod.obtenerCatProd(codigo));
             
             return "catprod/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarCatProd(CategoriaProductos cat, Model model, RedirectAttributes atributos){
             if (catprod.modificarCatProd(cat)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial modificada con exito");
                 return "redirect:/catprod/cat";
             }
             else
             {
                 model.addAttribute("listarCatProd", catprod.listarCategoriaProductos());
                 model.addAttribute("catprod", cat);
                 return "catprod/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarCatProd(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (catprod.eliminarCatProd(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/catprod/cat";
         }
    
}
