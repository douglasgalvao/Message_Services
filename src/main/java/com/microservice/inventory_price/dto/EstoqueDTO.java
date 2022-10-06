package com.microservice.inventory_price.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class EstoqueDTO implements Serializable {
    public String codigoProduto;
    public String quantidade;

}
