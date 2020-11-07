package com.api.market.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;
import com.api.market.dto.ProductDto;

import static br.com.fluentvalidator.predicate.ComparablePredicate.equalTo;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

public class ProductValidator extends AbstractValidator<ProductDto> {

    @Override
    public void rules() {
        ruleFor(ProductDto::getPrice)
                .must(greaterThan("0"))
                .when(not(nullValue()))
                .withMessage("O preço deve ser no mínimo maior que '0'")
                .withFieldName("price")
                .critical();

        ruleFor(ProductDto::getPrice)
                .must(not(StringPredicate.stringEmptyOrNull()))
                .when(not(nullValue()))
                .withMessage("Campo com formato inválido")
                .withFieldName("price")
                .critical();
    }

    @Override
    public boolean apply(Object instance, ProductDto value) {
        return false;
    }

    @Override
    public boolean support(ProductDto instance) {
        return false;
    }
}
