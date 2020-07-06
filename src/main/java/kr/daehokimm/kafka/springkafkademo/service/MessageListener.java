package kr.daehokimm.kafka.springkafkademo.service;

import kr.daehokimm.kafka.springkafkademo.configuration.KafkaConfigs;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageListener {

	@KafkaListener(topics = {KafkaConfigs.TOPIC_NAME})
	public void listen(ConsumerRecord<String, String> record) {
		log.info("[Consumer] consumed. Partition : {} / Offset : {} / Value : {}", record.partition(), record.offset(), record.value());
	}
}
