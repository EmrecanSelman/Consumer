package com.consumer.Consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "consumer")
@AllArgsConstructor
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String pass;
    @Column(length = 25)
    private String mail;

    public Consumer() {

    }


}
