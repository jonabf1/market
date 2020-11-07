package com.api.market.business;

import com.api.market.dto.ProductDto;
import com.api.market.entity.Product;
import com.api.market.handler.ValidationBadRequest;
import com.api.market.mapper.ProductMapperImpl;
import com.api.market.repository.ProductRepository;
import com.api.market.validator.ProductValidator;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBusiness {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductValidator productValidator;

    public Product salvar (ProductDto product){
      productValidator.validate(product);

      Product productMapped = ProductMapperImpl.INSTANCE.mapFrom(product);
//      Product productSaved = productRepository.save(productMapped);

      return productMapped;
    }

    public Optional<Product> recuperarPorId(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> recuperarTodos(){
        return productRepository.findAll();
    }

}
