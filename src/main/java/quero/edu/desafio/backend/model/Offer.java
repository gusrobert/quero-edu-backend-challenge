package quero.edu.desafio.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseName;

    @Column(precision=8, scale=2) 
    private BigDecimal rating;

    @Column(precision=8, scale=2) 
    private BigDecimal fullPrice;

    @Column(precision=8, scale=2) 
    private BigDecimal offeredPrice;
    private String kind;

    private String level;
    
    private String iesLogo;
    
    private String iesName;

    public Offer(){}
}
