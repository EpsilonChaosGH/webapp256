package morozov.services.business;

import morozov.entity.Group;

import java.util.List;

public interface GroupBusinessService {

    Group createGroup(Group group);

    List<Group> findAllGroups();

    void deleteGroup(Long id);
}
