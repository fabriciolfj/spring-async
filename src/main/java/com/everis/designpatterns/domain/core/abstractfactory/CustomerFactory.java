package com.everis.designpatterns.domain.core.abstractfactory;

import com.everis.designpatterns.api.dto.CustomerDto;
import com.everis.designpatterns.api.mapper.CustomerMapper;
import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.model.PersonLegal;
import com.everis.designpatterns.domain.model.PersonPhysical;
import com.everis.designpatterns.domain.model.enuns.TypeCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerFactory {

    private final CustomerMapper mapper;

    public Customer createCustomer(final CustomerDto dto) {

        switch (TypeCustomer.toEnum(dto.getType())) {
            case LEGAL_PERSON:
                return mapper.toModelPersonLegal(dto);
            case PHYSICAL_PERSON:
                return mapper.toModelPersonPhysical(dto);
            default:
                throw new RuntimeException("Type customer invalid. Type: " + dto.getType());

         }
    }

    public CustomerDto createCustomerDto(final Customer customer) {

        if(customer instanceof PersonPhysical) {
            return mapper.toDto((PersonPhysical) customer);
        }

        return mapper.toDto((PersonLegal) customer);
    }
}
