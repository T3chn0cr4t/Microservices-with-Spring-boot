package com.moncif.tp1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID ;
    @Column(name = "name" , nullable = false , length = 20)
    private String name ;
    @Temporal(TemporalType.DATE)
    private Date ddn ;
    @OneToOne
    private formation formation ;
}
