package com.microservice.inventory_price.controller;

import com.microservice.inventory_price.constants.RabbitMQConstants;
import com.microservice.inventory_price.dto.EstoqueDTO;
import com.microservice.inventory_price.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "estoque")
@RestController
public class PrecoController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @GetMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO){
        System.out.println(estoqueDTO.codigoProduto);
        this.rabbitmqService.enviaMensagem(RabbitMQConstants.FILA_ESTOQUE,estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
