package com.everis.designpatterns.domain.model;

import com.everis.designpatterns.domain.model.enuns.StatusRegister;
import com.everis.designpatterns.domain.model.enuns.TypeCustomer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DiscriminatorColumn(name = "type", length = 1,discriminatorType = DiscriminatorType.INTEGER)
public class Customer {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> adresses = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status_register")
    private StatusRegister statusRegister;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresses=" + adresses +
                ", statusRegister=" + statusRegister +
                '}';
    }
}
