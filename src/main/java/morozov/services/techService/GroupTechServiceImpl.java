package morozov.services.techService;

import morozov.dto.GroupDTO;
import morozov.entity.Group;
import morozov.services.business.GroupBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupTechServiceImpl implements GroupTechService {


    @Autowired
    GroupBusinessService groupBusinessService;

    public List<GroupDTO> groupToDTOs(List<Group> groups) {
        List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
        for (Group group : groups) {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setId(group.getId());
            groupDTO.setGroupName(group.getGroupName());
            groupDTOs.add(groupDTO);
        }

        return groupDTOs;
    }

    public void createGroup(GroupDTO groupDTO) {
        groupBusinessService.createGroup(new Group(groupDTO.getId(), groupDTO.getGroupName()));
    }
}

