package com.microservice.inventory_price.controller;
import com.microservice.inventory_price.constants.RabbitMQConstants;
import com.microservice.inventory_price.service.RabbitmqService;
import dto.PrecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "preco")
@RestController
public class PrecoController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PostMapping
    private ResponseEntity alteraPreco(@RequestBody PrecoDTO precoDTO){
        System.out.println(precoDTO.codigoProduto);
        this.rabbitmqService.enviaMensagem(RabbitMQConstants.FILA_PRECO,precoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
