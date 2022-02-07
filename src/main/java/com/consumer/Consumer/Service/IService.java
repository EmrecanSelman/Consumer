package com.consumer.Consumer.Service;

import com.consumer.Consumer.Model.Consumer;

import java.util.List;

public interface IService {
    Consumer saveConsumer(Consumer consumer);
    List<Consumer> getAllConsumer();
    Consumer getConsumer(int id);
    Consumer updateConsumer(Consumer consumer,int id);
    void deleteConsumer1(int id);
    boolean isValid(String name, String pass, String mail);
    void deleteConsumer(String name, String pass, String mail);
    void updateConsumer(String name, String pass, String mail,String oldMail);
}
