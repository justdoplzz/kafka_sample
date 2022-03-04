package com.example.kafka.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.dto.Message;

@RestController
@RequestMapping(path = "/producer")
public class KafkaProducerController {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@Value(value = "${kafka.topic_name}")
	private String kafkaTopicName;

	String status = "";

	@PostMapping(path = "/messages")
	public ResponseEntity<String> sendMessage(@RequestBody Message message) {
		logger.info("sending message {}", message);

		ListenableFuture<SendResult<String, Message>> future = this.kafkaTemplate.send(kafkaTopicName, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

			@Override
			public void onSuccess(SendResult<String, Message> result) {
				status = "Message sent successfully = 메시지가 성공적으로 전송 됬다구~!";
				logger.info("메시지가 성공적으로 전송 됬다구~! successfully sent message = {}, with offset = {}", message,
						result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.info("Failed to send message = {}, error = {}", message, ex.getMessage());
				status = "Message sending failed = 메시지 전송 실패...";
			}
		});
		return ResponseEntity.ok(status);
	}

}
