package com.mysite.prom.details;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.prom.coment.Coment;

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; 

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer category;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    
    @OneToMany(mappedBy = "details", cascade = CascadeType.REMOVE) 
    private List<Coment> comentList; 
}
