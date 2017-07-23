package morozov.services.techService;

import morozov.dto.GroupDTO;

import java.util.List;


public interface GroupTechService {

    void saveGroup(GroupDTO groupDTO);

    void saveGroupWithMessage(GroupDTO groupDTO);

    void deleteGroup(Long id);

    void deleteGroupWithMessage(Long id);

    List<GroupDTO> findAllGroups();

    GroupDTO findGroup(Long id);
}
