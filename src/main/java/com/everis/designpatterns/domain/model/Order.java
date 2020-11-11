package com.everis.designpatterns.domain.model;

import com.everis.designpatterns.domain.model.enuns.StatusOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String describe;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "amount_items")
    private Long amountItems;
    private BigDecimal total = new BigDecimal(0);
    @Enumerated(EnumType.STRING)
    @Column(name = "status_order")
    private StatusOrder statusOrder;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public void setTotal(BigDecimal total) {
        orderItems.stream().forEach(item -> {
            this.total.add(item.getTotal());
        });
    }
}
