package com.api.market.business;

import com.api.market.dto.ProductDto;
import com.api.market.entity.Product;
import com.api.market.mapper.ProductMapperImpl;
import com.api.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBusiness {

    @Autowired
    ProductRepository productRepository;

    public Product salvar (ProductDto product){
      Product productSaved = productRepository.save(ProductMapperImpl.INSTANCE.mapFrom(product));

      return productSaved;
    }

    public Optional<Product> recuperarPorId(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> recuperarTodos(){
        return productRepository.findAll();
    }

}
