package com.api.market.business;

import br.com.fluentvalidator.context.ValidationResult;
import com.api.market.dto.ProductDto;
import com.api.market.entity.Product;
import com.api.market.handler.ValidationSampleException;
import com.api.market.mapper.ProductMapperImpl;
import com.api.market.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBusiness {

//    @Autowired
//    ProductRepository productRepository;

    @Autowired
    ProductValidator productValidator;

    public Product salvar (ProductDto product){
        Product productMapped = ProductMapperImpl.INSTANCE.mapFrom(product);

        ValidationResult resultValidation = productValidator.validate(product);

        System.out.println(resultValidation.toString());
        if(!resultValidation.isValid()){
            throw new ValidationSampleException(resultValidation);
        }

//      Product productSaved = productRepository.save(productMapped);

      return productMapped;
    }

//    public Optional<Product> recuperarPorId(Integer id){
//        return productRepository.findById(id);
//    }
//
//    public List<Product> recuperarTodos(){
//        return productRepository.findAll();
//    }

}
