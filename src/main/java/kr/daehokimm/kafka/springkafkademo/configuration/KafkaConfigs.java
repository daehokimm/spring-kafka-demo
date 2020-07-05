package kr.daehokimm.kafka.springkafkademo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class KafkaConfigs {

	public static final String TOPIC_NAME = "spring-kafka-demo-topic";
	public static final int PARTITION_NUM = 3;
	public static final short REPLICATION_FACTOR = 3;

	@Bean
	public NewTopic newTopic() {
		return new NewTopic(TOPIC_NAME, PARTITION_NUM, REPLICATION_FACTOR);
	}
}
