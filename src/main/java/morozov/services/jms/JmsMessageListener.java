package morozov.services.jms;

import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;
import morozov.services.techService.GroupTechService;
import morozov.services.techService.ProductTechService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


public class JmsMessageListener implements MessageListener {

    @Autowired
    private GroupTechService groupTechService;

    @Autowired
    private ProductTechService productTechService;

    public void onMessage(Message message) {
        try {
            // добавление объектов из сообщения
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                if (objectMessage.getObject() instanceof GroupDTO) {
                    GroupDTO groupDTO = (GroupDTO) objectMessage.getObject();
                    groupTechService.saveGroup(groupDTO);
                }
                if (objectMessage.getObject() instanceof ProductDTO) {
                    ProductDTO productDTO = (ProductDTO) objectMessage.getObject();
                    productTechService.saveProduct(productDTO);
                }
            }

            // удаление
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                if (textMessage.getStringProperty("type").equals(GroupDTO.class.getSimpleName())) {
                    groupTechService.deleteGroup(textMessage.getLongProperty("id"));
                }
                if (textMessage.getStringProperty("type").equals(ProductDTO.class.getSimpleName())) {
                    productTechService.deleteProduct(textMessage.getLongProperty("id"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}