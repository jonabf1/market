package com.api.market.controller;

import com.api.market.business.ProductBusiness;
import com.api.market.controller.resource.ResponseResource;
import com.api.market.dto.ProductDto;
import com.api.market.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/market")
public class ProductController {

    @Autowired
    ProductBusiness productBusiness;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody @Valid ProductDto product){
       Product response = productBusiness.salvar(product);
       return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseResource(response));
    }

//    @GetMapping
//    public ResponseEntity<Object> get(){
//            List<Product> product = productBusiness.recuperarTodos();
//            if(Objects.isNull(product)) return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseResource(product));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getById(@PathVariable Integer id) {
//            Optional<Product> product = productBusiness.recuperarPorId(id);
//            if(!product.isPresent()) return ResponseEntity.notFound().build();
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseResource(product.get()));
//    }

}
