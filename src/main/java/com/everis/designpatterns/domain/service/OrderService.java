package com.everis.designpatterns.domain.service;

import com.everis.designpatterns.api.dto.OrderDto;
import com.everis.designpatterns.api.mapper.OrderMapper;
import com.everis.designpatterns.infrastructure.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ApplicationEventPublisher eventPublisher;

    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> orderMapper.toDto(order))
                .collect(Collectors.toList());
    }
}
