package in.jaiprakash.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageConfiguration {

    public static final String ZENIKA_DEMO = "enika-Demo";

    /**
     * we will first create queue and Topic Exchange
     * Go back to diagram and show what we have achieved
     */

    @Bean
    public Queue queue(){
        return new Queue( ZENIKA_DEMO);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("Zenika-exchange");
    }

    /**
     * Now binding is pending
     */

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange)
                .with("Zenika-routingkey");
    }

    /**
     * Now since we are playing with spring data types but objects so need to create a converter
     */

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Need to add template
     */

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
