package morozov.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Table(name = "pers_product")
@SequenceGenerator(name = "pers_product_seq", sequenceName = "pers_product_seq", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_product_seq")
    private Long id;
    private String productName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;
}