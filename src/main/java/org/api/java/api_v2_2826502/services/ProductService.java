package org.api.java.api_v2_2826502.services;

import jakarta.transaction.Transactional;
import org.api.java.api_v2_2826502.entities.Product;
import org.api.java.api_v2_2826502.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductService {

    /*dependecia inyectada
    * bjeto necesario para cumplir}operaciones en la clase*/
    @Autowired
    private ProductRepository repositorio;

    //CRUD
    /*seleccionar todos los producctos*/
    public List<Product> findAll(){

        //seleccionar todos los productos
        return (List<Product>)
                repositorio.findAll();

    }

    //seleccionar producctos por id
    //SQL select from where id =
    public Product findById(Long id){

        return repositorio.findById(id).get();
    }
    //INSERTAR NUEVO PRODUCTO
    @Transactional
    public  Product save(Product product){
        return  repositorio.save(product);
    }

    //actualizar producto
    @Transactional
    public Product cambiarProducto(Product product, Long id){
        //1. obtener el producto por id
        Product prodUpd = this.findById(id);
        //2. actualizar el estado del objeto
        //  encontrado(actualizar atributos)
        prodUpd.setName(product.getName());
        prodUpd.setPrice(product.getPrice());
        prodUpd.setName(product.getName());
        //3. Grabar(guardar) cambios en bd
        return repositorio.save(prodUpd);
    }

    //eliminar producto

}
