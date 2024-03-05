package com.booksparadise.comunidade.client;

import com.booksparadise.comunidade.client.dto.EventResponse;
import com.booksparadise.comunidade.config.EventClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "eventClient",
        url = "http://localhost:8081",
        configuration = EventClientConfig.class
)
public interface EventClient {
    @GetMapping("/events")
    public List<EventResponse> findAll();
}
