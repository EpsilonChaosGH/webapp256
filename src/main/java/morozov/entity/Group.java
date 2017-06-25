package morozov.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pers_group")
@SequenceGenerator(name = "pers_group_seq", sequenceName = "pers_group_seq", allocationSize = 1)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_group_seq")
    private Long id;
    private String groupName;

}
