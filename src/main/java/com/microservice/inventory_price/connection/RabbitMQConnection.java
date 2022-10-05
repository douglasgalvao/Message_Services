package com.microservice.inventory_price.connection;

import com.microservice.inventory_price.contants.RabbitMQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

    private static final String NOME_EXCHANGE = "amq.direct";

    private Queue fila(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca) {
        return new Binding(fila.getName(), Binding.DestinationType.EXCHANGE, troca.getName(), fila.getName(), null);
    }

    private void adiciona() {
        Queue filaEstoque = this.fila(RabbitMQConstants.FILA_ESTOQUE);
        Queue filaPreco = this.fila(RabbitMQConstants.FILA_PRECO);

        DirectExchange troca = this.trocaDireta();
        Binding relaciona = this.relacionamento(filaEstoque, troca);
    }

}