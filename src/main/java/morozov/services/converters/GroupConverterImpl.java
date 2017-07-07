package morozov.services.converters;

import morozov.dto.GroupDTO;
import morozov.entity.Group;
import morozov.services.business.GroupBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupConverterImpl implements GroupConverter {


    public GroupDTO groupToDTO(Group group){
        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId(group.getId());
        groupDTO.setGroupName(group.getGroupName());

        return  groupDTO;
    }

    public List<GroupDTO> groupToDTOs(List<Group> groups) {
        List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();

        if (groups == null) {
            return groupDTOs;
        }

        for (Group group : groups) {
            groupDTOs.add(groupToDTO(group));
        }

        return groupDTOs;
    }

    public Group groupToEntity(GroupDTO groupDTO) {
        Group group = new Group();

        group.setId(groupDTO.getId());
        group.setGroupName(groupDTO.getGroupName());

        return group;
    }

    public List<Group> groupToEntitys(List<GroupDTO> groupDTOs) {
        List<Group> groups = new ArrayList<Group>();

        if (groupDTOs == null) {
            return groups;
        }

        for (GroupDTO groupDTO : groupDTOs) {
            groups.add(groupToEntity(groupDTO));
        }
        return groups;
    }
}
