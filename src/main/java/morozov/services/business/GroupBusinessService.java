package morozov.services.business;

import morozov.entity.Group;

import java.util.List;

public interface GroupBusinessService {

    Group saveGroup(Group group);

    List<Group> findAllGroups();

    void deleteGroup(Long id);

    Group findGroup(Long id);
}
