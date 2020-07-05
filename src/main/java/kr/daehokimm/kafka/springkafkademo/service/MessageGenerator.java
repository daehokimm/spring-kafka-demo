package kr.daehokimm.kafka.springkafkademo.service;

import kr.daehokimm.kafka.springkafkademo.configuration.KafkaConfigs;
import kr.daehokimm.kafka.springkafkademo.service.callback.ProducerCallback;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class MessageGenerator {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final Random random = new Random(System.currentTimeMillis());

	public static final int MAX_STR_LENGTH = 20;

	@Scheduled(cron = "0/1 * * * * *")
	public void generateMessage() {
		kafkaTemplate.send(KafkaConfigs.TOPIC_NAME, generateString())
				.addCallback(new ProducerCallback());
	}

	private String generateString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MAX_STR_LENGTH; i++) {
			sb.append((char) (random.nextInt(78) + 48));
		}
		return sb.toString();
	}
}
