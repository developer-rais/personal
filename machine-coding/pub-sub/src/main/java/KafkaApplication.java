import com.pubsub.service.KafkaProducerImpl;
import com.pubsub.service.ProducerService;
import com.pubsub.service.PubSubService;

public class KafkaApplication {

    public static void main(String[] args) {

        PubSubService pubSubService=new PubSubService();
        ProducerService<String> producerService=new KafkaProducerImpl<>();
    }
}
