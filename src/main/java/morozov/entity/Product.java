package morozov.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pers_product")
@SequenceGenerator(name = "pers_product_seq", sequenceName = "pers_product_seq", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_product_seq")
    private Long id;
    private String productName;

    @Transient
    private Long groupId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    private Group group;
}