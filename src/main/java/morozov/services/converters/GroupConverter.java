package morozov.services.converters;

import morozov.dto.GroupDTO;
import morozov.entity.Group;

import java.util.List;


public interface GroupConverter {

    GroupDTO groupToDTO(Group group);

    List<GroupDTO> groupToDTOs(List<Group> groups);

    Group groupToEntity(GroupDTO groupDTO);

    List<Group> groupToEntities(List<GroupDTO> groupDTOs);

}
