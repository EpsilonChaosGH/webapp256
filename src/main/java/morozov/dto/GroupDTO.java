package morozov.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GroupDTO implements Serializable {

    private Long id;
    private String groupName;
}
