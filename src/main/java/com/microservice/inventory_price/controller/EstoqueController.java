package com.microservice.inventory_price.controller;

import com.microservice.inventory_price.constants.RabbitMQConstants;
import com.microservice.inventory_price.service.RabbitmqService;
import dto.EstoqueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PostMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO){
        this.rabbitmqService.enviaMensagem(RabbitMQConstants.FILA_ESTOQUE,estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
