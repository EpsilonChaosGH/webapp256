package morozov.services.business;

import morozov.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupBusinessService {

    Group createGroup(Group group);

    Page<Group> findAllGroups(Pageable pageable);

}
