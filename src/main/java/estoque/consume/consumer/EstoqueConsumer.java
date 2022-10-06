package estoque.consume.consumer;

import dto.PrecoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.microservice.inventory_price.constants.RabbitMQConstants;
import org.springframework.stereotype.Component;
import dto.EstoqueDTO;

@Component
public class EstoqueConsumer {


    @RabbitListener(queues = RabbitMQConstants.FILA_ESTOQUE)
    private void consumer(EstoqueDTO estoqueDTO){
        System.out.println(estoqueDTO.codigoProduto);
        System.out.println(estoqueDTO.quantidade);
        System.out.println("-------------------");
    }


}
