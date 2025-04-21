package com.seuprojeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FipController {

    private final String URL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json";

    @GetMapping("/fip")
    public String obterDadosFip() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL, String.class);
    }
}
