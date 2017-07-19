package morozov.services.jms;

import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;
import morozov.services.converters.GroupConverter;
import morozov.services.converters.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;


@Service
public class JmsMessageSenderImpl implements JmsMessageSender {

    @Autowired
    private GroupConverter groupConverter;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendAddProduct(final ProductDTO productDTO) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(productConverter.productToEntity(productDTO));
                return objectMessage;

            }
        });
    }

    public void sendAddGroup(final GroupDTO groupDTO) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(groupConverter.groupToEntity(groupDTO));
                return objectMessage;

            }
        });
    }

    public void sendDelObject(final Long id, final String type) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setStringProperty("type", type);
                textMessage.setLongProperty("id", id);
                return textMessage;

            }
        });
    }
}

