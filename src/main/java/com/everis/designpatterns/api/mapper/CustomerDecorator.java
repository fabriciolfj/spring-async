package com.everis.designpatterns.api.mapper;

import com.everis.designpatterns.api.dto.AddressDto;
import com.everis.designpatterns.api.dto.CustomerDto;
import com.everis.designpatterns.domain.model.Address;
import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.model.PersonLegal;
import com.everis.designpatterns.domain.model.PersonPhysical;
import com.everis.designpatterns.domain.model.enuns.TypeCustomer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class CustomerDecorator implements CustomerMapper {

    @Autowired
    private CustomerMapper mapper;

    @Override
    public CustomerDto toDto(PersonLegal personLegal) {
        return CustomerDto
                .builder()
                .name(personLegal.getName())
                .type(TypeCustomer.LEGAL_PERSON.getDescribe())
                .document(personLegal.getCnpj())
                .addressDto(getAdresses(personLegal))
                .build();
    }

    @Override
    public CustomerDto toDto(PersonPhysical personPhysical) {
        return CustomerDto
                .builder()
                .name(personPhysical.getName())
                .type(TypeCustomer.PHYSICAL_PERSON.getDescribe())
                .document(personPhysical.getCpf())
                .addressDto(getAdresses(personPhysical))
                .build();
    }

    @Override
    public PersonPhysical toModelPersonPhysical(CustomerDto dto) {
        PersonPhysical customer = mapper.toModelPersonPhysical(dto);
        customer.setCpf(dto.getDocument());
        setAdresses(dto, customer);

        return customer;
    }

    @Override
    public PersonLegal toModelPersonLegal(CustomerDto dto) {
        PersonLegal customer = mapper.toModelPersonLegal(dto);
        customer.setCnpj(dto.getDocument());
        setAdresses(dto, customer);

        return customer;

    }

    private void setAdresses(CustomerDto dto, Customer customer) {
        customer.setAdresses(dto.getAddressDto().stream().map(d -> Address.builder()
                            .city(d.getCity())
                            .customer(customer)
                            .street(d.getStreet())
                            .neighborhood(d.getNeighborhood())
                            .number(d.getNumber())
                            .build()).collect(Collectors.toList()));
    }

    private List<AddressDto> getAdresses(final Customer customer) {
        return customer.getAdresses()
                .stream()
                .map(d ->  AddressDto.builder()
                        .city(d.getCity())
                        .neighborhood(d.getNeighborhood())
                        .number(d.getNumber())
                        .street(d.getStreet())
                        .build())
                .collect(Collectors.toList());
    }
}
