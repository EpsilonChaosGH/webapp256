package morozov.services.business;


import morozov.entity.Group;
import morozov.entity.Product;
import morozov.repository.GroupRepository;
import morozov.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GroupBusinessServiceImpl implements GroupBusinessService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    ProductBusinessService productBusinessService;
    @Autowired

    private ProductRepository productRepository;

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group findGroup(Long id) {
        return groupRepository.findOne(id);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }


    public void deleteGroup(Long id) {
        for (Product product : productBusinessService.findAllProducts()) {
            if (product.getGroup().getId().equals(id)) {
                productBusinessService.deleteProduct(product.getId());
            }
        }
        groupRepository.delete(id);
    }

}

    
    
    
    

