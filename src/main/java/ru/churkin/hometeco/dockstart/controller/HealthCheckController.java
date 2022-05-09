package ru.churkin.hometeco.dockstart.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.churkin.hometeco.dockstart.model.hc.HealthCheckResponse;
import ru.churkin.hometeco.dockstart.model.hc.HealthCheckStatus;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthCheckController {

    @GetMapping(value = "/health")
    public HealthCheckResponse healthCheck1()
    {
        return HealthCheckResponse.of(HealthCheckStatus.OK);
    }

    @GetMapping(value = "/")
    public HealthCheckResponse healthCheck2()
    {
        return HealthCheckResponse.of(HealthCheckStatus.OK);
    }

    @PostMapping(value = "/")
    public String welcomePage() {
        return "Welcome! This page is empty. Try to call another URL";
    }
}
