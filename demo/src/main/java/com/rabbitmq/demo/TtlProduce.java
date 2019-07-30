package com.rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TtlProduce {
    public static void main(String args[])  throws Exception{
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setPassword("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("192.168.1.141");
        connectionFactory.setPort(5672);
        Connection connection=connectionFactory.newConnection();
        Channel channel= connection.createChannel();
        /**
         * 死信队列出现原因
         * 消息被拒绝 (Basic.Reject/Basic .Na ck) ，井且设置 requeue 参数为 alse;
         * 消息过期;
         * 队列达到最大长度。
         */
        //死信队列
        channel.exchangeDeclare("exchange.dlx" , "direct" , true);
        //正常队列，先发送消息到正常队列，
        channel.exchangeDeclare( "exchange.normal" , "fanout" , true);
        Map<String , Object> map = new HashMap<String, Object>( );
        //消息在正常队列过期时间
        map.put("x-message-ttl" , 10000);
        //关联的死信队列
        map.put("x-dead-letter-exchange" , "exchange.dlx");
        // 死信队列路由key
        map.put("x-dead-letter-routing-key" , "routingkey");
        //正常队列绑定exchange
        channel.queueDeclare("queue.norma1" ,true ,false,false, map);
        channel.queueBind("queue.norma1" , "exchange.normal" , "");
        // 死信队列绑定exchang
        channel.queueDeclare("queue.d1x" , true , false , false , null) ;
        channel.queueBind("queue.d1x" ,"exchange.dlx" ,"routingkey");
                channel.basicPublish( "exchange.normal" , "rk" ,
                        MessageProperties.PERSISTENT_TEXT_PLAIN, "dlx" .getBytes()) ;
    }
}
