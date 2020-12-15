/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Productos;
import indieshop.model.ProductosModel;
import indieshop.model.CatProdModel;
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
 
 @RequestMapping("productos")

public class ProductosController {
    
    ProductosModel producto = new ProductosModel();
    CatProdModel categoria= new CatProdModel();
    ProveedorModel proveedor= new ProveedorModel();
    
    @RequestMapping("prod")
    public String listarProducto(Model model) {
        model.addAttribute("lp", producto.listarProductos());
       
        return "productos/listar";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoProducto(Model model) {
         model.addAttribute("listaCat", categoria.listarCatProd());
        model.addAttribute("listaProv", proveedor.listarProveedor());
         model.addAttribute("producto", new Productos());
        return "productos/nuevo";
    }
    
    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarProducto(@ModelAttribute("producto") Productos prod, Model model, RedirectAttributes atributos) {
        if (producto.insertarProductos(prod) > 0) {
            atributos.addFlashAttribute("exito", "producto registrado exitosamente");
            return "redirect:/productos/prod";
        } else {
            model.addAttribute("listarProducto", producto.listarProductos());
            model.addAttribute("Catprod", prod);
                       return "productos/nuevo";

        }
    }
    
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerProducto(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("listaCat", categoria.listarCatProd());
        model.addAttribute("listaProv", proveedor.listarProveedor());
             model.addAttribute("producto", producto.obtenerProductos(codigo));
             
             return "productos/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarProducto(Productos prod, Model model, RedirectAttributes atributos){
             
             if (producto.modificarProductos(prod)>0)
             {
                 atributos.addFlashAttribute("exito", "producto modificada con exito");
                 return "redirect:/productos/prod";
             }
             else
             {
                 model.addAttribute("listarProducto", producto.listarProductos());
                 model.addAttribute("proveedor", prod);
                 return "productos/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarProducto(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (producto.eliminarProductos(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "producto eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/productos/prod";
         }
         
         @RequestMapping (value = "verpro/{codigo}", method = RequestMethod.GET)
         public String verProducto(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("producto", producto.obtenerProductos(codigo));
             
             return "productos/ver";
         }
    
}
