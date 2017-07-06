package morozov.services.techService;

import morozov.dto.GroupDTO;
import morozov.entity.Group;

import java.util.List;


public interface GroupTechService {

    List<GroupDTO> groupToDTOs(List<Group> groups);

     void createGroup(GroupDTO groupDTO);

}
