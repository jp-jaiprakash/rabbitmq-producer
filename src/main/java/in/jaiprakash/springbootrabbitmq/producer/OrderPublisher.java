package in.jaiprakash.springbootrabbitmq.producer;

import in.jaiprakash.springbootrabbitmq.dto.Order;
import in.jaiprakash.springbootrabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        // in normal scenario
        // restaurantService
        // paymentservice
        // we dont want to wait for the

        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "placed successfully"+ restaurantName);
        System.out.println("Placing order::"+ orderStatus);
        template.convertAndSend("Zenika-exchange", "Zenika-routingkey", orderStatus);
        return "Success!!";
    }
}
