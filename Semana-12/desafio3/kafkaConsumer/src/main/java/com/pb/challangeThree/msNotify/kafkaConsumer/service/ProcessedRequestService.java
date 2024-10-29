package com.pb.challangeThree.msNotify.kafkaConsumer.service;

import com.pb.challangeThree.msNotify.kafkaConsumer.record.ProcessedRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProcessedRequestService {

    @KafkaListener(topics = "request-processed", containerFactory = "requestKafkaListenerContainerFactory")
    public void requestListener(ProcessedRequest request) {
        System.out.println("Received Message: \n" + request.username() + "\n" +  request.operation());
    }

}
