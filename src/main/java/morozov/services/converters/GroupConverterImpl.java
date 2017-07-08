package morozov.services.converters;

import morozov.dto.GroupDTO;
import morozov.entity.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupConverterImpl implements GroupConverter {


    public GroupDTO groupToDTO(Group group) {
        if (group == null) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId(group.getId());
        groupDTO.setGroupName(group.getGroupName());

        return groupDTO;
    }

    public List<GroupDTO> groupToDTOs(List<Group> groups) {
        if (groups == null) {
            return null;
        }

        List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();

        for (Group group : groups) {
            groupDTOs.add(groupToDTO(group));
        }

        return groupDTOs;
    }

    public Group groupToEntity(GroupDTO groupDTO) {
        if (groupDTO == null) {
            return null;
        }
        Group group = new Group();

        group.setId(groupDTO.getId());
        group.setGroupName(groupDTO.getGroupName());

        return group;
    }

    public List<Group> groupToEntities(List<GroupDTO> groupDTOs) {
        if (groupDTOs == null) {
            return null;
        }

        List<Group> groups = new ArrayList<Group>();

        for (GroupDTO groupDTO : groupDTOs) {
            groups.add(groupToEntity(groupDTO));
        }
        return groups;
    }
}
