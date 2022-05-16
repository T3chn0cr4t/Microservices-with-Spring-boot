package com.moncif.tp1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formationID ;
    @Column(name = "name" , nullable = false , length = 20)
    private String name ;
    @OneToMany(mappedBy = "studentID")
    Collection<student> students ;
}
