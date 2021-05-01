package com.api.market.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;
import com.api.market.dto.ProductDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.ComparablePredicate.equalTo;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

@Component
public class ProductValidator extends AbstractValidator<ProductDto> {

    @Override
    public void rules() {

        ruleFor(ProductDto::getPrice)
                .must(greaterThan("0"))
                     .when(not(nullValue()))
                     .withMessage("O preço deve ser no mínimo maior que '0'")
                     .withFieldName("price");

        ruleFor(ProductDto::getTitle)
                .must(not(StringPredicate.stringEmptyOrNull()))
                .when(not(nullValue()))
                .withMessage("Campo com formato inválido")
                .withFieldName("title")
                .critical();
    }

}
