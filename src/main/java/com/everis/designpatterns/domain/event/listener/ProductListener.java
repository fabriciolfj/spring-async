package com.everis.designpatterns.domain.event.listener;

import com.everis.designpatterns.domain.commands.Process;
import com.everis.designpatterns.domain.event.ProductEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductListener {

    private final List<Process> processList;

    @EventListener
    @Async
    public void productEvent(final ProductEvent event) {
        processList.stream().forEach(p -> {
            p.execute(event.getProduct());
        });
    }
}
