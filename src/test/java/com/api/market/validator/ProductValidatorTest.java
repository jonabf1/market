package com.api.market.validator;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.api.market.dto.ProductDto;
import org.hibernate.annotations.Parent;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class ProductValidatorTest {

    @Test
    public void deveValidarCampos(){
        final Validator<ProductDto> productValidator = new ProductValidator();

        final ProductDto productDto = new ProductDto();

        productDto.setTitle(null);
        productDto.setPrice(null);
        productDto.setType(null);

        final ValidationResult result = productValidator.validate(productDto);

        assertThat(result.getErrors(), not(empty()));
        assertThat(result.getErrors(), hasSize(5));

        assertThat(result.getErrors(), hasItem(hasProperty("field", containsString("title"))));
        assertThat(result.getErrors(), hasItem(hasProperty("attemptedValue", containsString(null))));
        assertThat(result.getErrors(), hasItem(hasProperty("message", containsString("Campo com formato inválido"))));
//        assertThat(result.getErrors(), hasItem(hasProperty("code", nullValue())));
    }

}
