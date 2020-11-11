package com.everis.designpatterns.api.mapper;

import com.everis.designpatterns.api.dto.CustomerDto;
import com.everis.designpatterns.domain.model.PersonLegal;
import com.everis.designpatterns.domain.model.PersonPhysical;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(CustomerDecorator.class)
public interface CustomerMapper {

    PersonLegal toModelPersonLegal(final CustomerDto dto);

    PersonPhysical toModelPersonPhysical(final CustomerDto dto);

    CustomerDto toDto(final PersonLegal personLegal);

    CustomerDto toDto(final PersonPhysical PersonPhysical);
}
