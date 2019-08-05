package com.kafka.demo;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.Future;

public class Produces {
     public static  void main(String args[]) throws  Exception{
         System.out.println("pb");
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
        //同步发送
         for(int i = 0; i < 100; i++) {
             //kafka 封装ProducerRecord，发送到broker
             //send 异步方法，返回future ,设置回调方法，或者直接调用get()将阻塞执行
             //不使用键值对，值有主题和值，默认是轮训消息发送到每一个分区
             Future<RecordMetadata> recordMetadata=
                     producer.send(new ProducerRecord<String, String>("test",
                     Integer.toString(i), Integer.toString(i)));
             //使用键值对，同一键值对的消息只会发送到一个分区
             producer.send(new ProducerRecord<>("test", "111", Integer.toString(i)));
             RecordMetadata record=recordMetadata.get();
             System.out.println(record.topic());
         }
         for (int i = 100; i <200 ; i++) {
             Future<RecordMetadata> recordMetadata= producer
                     .send(new ProducerRecord<>("test11", Integer.toString(i)), new Callback() {
                 @Override
                 public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                     System.out.println(recordMetadata.partition()+"--------");
                 }
             });
             RecordMetadata record=recordMetadata.get();
             System.out.println(record.partition()+"22222222222");
         }
         producer.close();
     }
}
