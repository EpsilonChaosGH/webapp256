package morozov.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDTO implements Serializable {

    private Long id;
    private String productName;
    private GroupDTO group;
    private Long groupId;
}
