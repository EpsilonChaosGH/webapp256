package morozov.services.jms;

import morozov.entity.Group;
import morozov.entity.Product;
import morozov.services.business.GroupBusinessService;
import morozov.services.business.ProductBusinessService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


public class JmsMessageListener implements MessageListener {

    @Autowired
    private GroupBusinessService groupBusinessService;

    @Autowired
    private ProductBusinessService productBusinessService;


    public synchronized void onMessage(Message message) {
        try {
            // добавление объектов из сообщения
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                if (objectMessage.getObject() instanceof Group) {
                    Group group = (Group) objectMessage.getObject();
                    groupBusinessService.saveGroup(group);

                }
                if (objectMessage.getObject() instanceof Product) {
                    Product product = (Product) objectMessage.getObject();
                    productBusinessService.saveProduct(product);
                }

            }
            // удаление
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                if (textMessage.getStringProperty("type").equals("group")) {
                    groupBusinessService.deleteGroup(textMessage.getLongProperty("id"));
                }
                if (textMessage.getStringProperty("type").equals("product")) {
                    productBusinessService.deleteProduct(textMessage.getLongProperty("id"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}