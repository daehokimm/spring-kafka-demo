package kr.daehokimm.kafka.springkafkademo.service.callback;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public class ProducerCallback implements ListenableFutureCallback<SendResult<String, String>> {
	@Override
	public void onFailure(Throwable ex) {
		log.error("[Producer] fail", ex);
	}

	@Override
	public void onSuccess(SendResult<String, String> result) {
		RecordMetadata metadata = result.getRecordMetadata();
		log.info("[Producer] success. Partition : {} / Offset : {}", metadata.partition(), metadata.offset());
	}
}
