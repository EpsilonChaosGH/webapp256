package morozov.services.techService;

import morozov.dto.GroupDTO;
import morozov.entity.Group;
import morozov.services.business.GroupBusinessService;
import morozov.services.converters.GroupConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupTechServiceImpl implements GroupTechService {

    @Autowired
    private GroupBusinessService groupBusinessService;

    @Autowired
    private GroupConverter groupConverter;

    public void createGroup(GroupDTO groupDTO) {
        groupBusinessService.createGroup(groupConverter.groupToEntity(groupDTO));
    }

    public List<GroupDTO> findAllGroups() {
        List<Group> groups = groupBusinessService.findAllGroups();
        return groupConverter.groupToDTOs(groups);

    }
    public void deleteGroup(Long id) {
        groupBusinessService.deleteGroup(id);
    }
}

