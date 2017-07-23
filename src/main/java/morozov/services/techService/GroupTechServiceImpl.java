package morozov.services.techService;

import morozov.dto.GroupDTO;
import morozov.services.business.GroupBusinessService;
import morozov.services.converters.GroupConverter;
import morozov.services.jms.JmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupTechServiceImpl implements GroupTechService {

    @Autowired
    private JmsMessageSender jmsMessageSender;

    @Autowired
    private GroupBusinessService groupBusinessService;

    @Autowired
    private GroupConverter groupConverter;

    public void saveGroup(GroupDTO groupDTO) {
        groupBusinessService.saveGroup(groupConverter.groupToEntity(groupDTO));
    }

    public void saveGroupWithMessage(GroupDTO groupDTO) {
        groupBusinessService.saveGroup(groupConverter.groupToEntity(groupDTO));
        jmsMessageSender.sendAddGroup(groupDTO);
    }

    public List<GroupDTO> findAllGroups() {
        return groupConverter.groupToDTOs(groupBusinessService.findAllGroups());
    }

    public void deleteGroup(Long id) {
        groupBusinessService.deleteGroup(id);
    }

    public void deleteGroupWithMessage(Long id) {
        groupBusinessService.deleteGroup(id);
        jmsMessageSender.sendDelObject(id, GroupDTO.class.getSimpleName());
    }

    public GroupDTO findGroup(Long id) {
        return groupConverter.groupToDTO(groupBusinessService.findGroup(id));
    }
}

