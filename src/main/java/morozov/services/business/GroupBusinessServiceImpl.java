package morozov.services.business;


import morozov.entity.Group;
import morozov.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GroupBusinessServiceImpl implements GroupBusinessService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public void   deleteGroup (Long id){
         groupRepository.delete(id);
    }

    public Group findGroup(Long id){
        return groupRepository.getOne(id);
    }
}

    
    
    
    

