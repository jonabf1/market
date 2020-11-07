package com.api.market.mapper;

import com.api.market.dto.ProductDto;
import com.api.market.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ProductMapper {
   public static final ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

   @Mapping(source = "price", target = "price", defaultValue = "0")
   public abstract Product mapFrom(ProductDto productDto);

}
