package org.api.java.api_v2_2826502.controllers;

import org.api.java.api_v2_2826502.entities.Product;
import org.api.java.api_v2_2826502.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    //inyectar el servicio
    @Autowired
    private ProductService servicio;

    //Endpoint
    //listar todos los productos
    @GetMapping
    public List<Product> getProducts(){
        return servicio.findAll();
    }

    //endpoint
    //listar un producto por ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return servicio.findById(id);
    }

    //endpoint
    //crear un producto
    @PostMapping("/products")
        public Product crearProducto
                (@RequestBody Product product){
            return servicio.save(product);
    }

    //Endpoint: actualizar un producto
    @PutMapping("/products/{id}")
    Product actualizarProducto(
                @RequestBody Product product,
                @PathVariable Long id){
        return servicio.cambiarProducto(product, id);
    }

}
