package com.kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Produces {
     public static  void main(String args[]){
         Properties props = new Properties();
         props.put("bootstrap.servers", "192.168.1.131:9092");//连接地址
         props.put("acks", "all");//应答模式 全部发送成功才应答
         props.put("retries", 0);//重试次数
         props.put("batch.size", 16384);//缓存未发送的的数据
         props.put("linger.ms", 1);//立即发送时间，即缓存还未满也发送数据到topic
         props.put("buffer.memory", 33554432);//缓存总量
         props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
         props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

         Producer<String, String> producer = new KafkaProducer<String,String>(props);
         for(int i = 0; i < 100; i++) {
             //send 异步方法，返回future ,设置回调方法，或者直接调用get()将阻塞执行
             producer.send(new ProducerRecord<String, String>("test",
                     Integer.toString(i), Integer.toString(i)));
         }
         producer.close();
     }
}
