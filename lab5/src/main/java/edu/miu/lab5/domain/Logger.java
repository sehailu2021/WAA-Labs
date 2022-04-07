package com.example.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date  ;
    private String time;
    private String principle;
    private String operation;

}
