package morozov.services.techService;

import morozov.dto.GroupDTO;
import morozov.entity.Group;

import java.util.List;


public interface GroupTechService {

     void createGroup(GroupDTO groupDTO);

    List<GroupDTO> findAllGroups();

    void deleteGroup(Long id);
}
