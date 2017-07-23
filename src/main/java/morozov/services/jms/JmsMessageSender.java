package morozov.services.jms;

import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;

public interface JmsMessageSender {

    void sendAddProduct(ProductDTO productDTO);

    void sendAddGroup(GroupDTO groupDTO);

    void sendDelObject(Long id, String type);

}
