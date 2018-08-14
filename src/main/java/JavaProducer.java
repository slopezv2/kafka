import  org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class JavaProducer  {
    public static void main(String[] args){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers","127.0.0.1:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer",StringSerializer.class.getName());
        props.setProperty("auto.offset.reset","earliest");
        props.setProperty("acks","1");
        props.setProperty("retries","3");
        props.setProperty("lingers.ms","1");
        KafkaProducer<String,String> prod = new KafkaProducer<String, String>(props);
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("first_topic","1","Hello World");
        prod.send(record);
        prod.flush();
        prod.close();
    }

}
