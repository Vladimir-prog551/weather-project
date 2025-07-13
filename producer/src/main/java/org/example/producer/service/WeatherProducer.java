package org.example.producer.service;

import org.example.dto.WeatherDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherProducer {

    private final KafkaTemplate<String, WeatherDto> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final WeatherService weatherService;

    public WeatherProducer(KafkaTemplate<String, WeatherDto> kafkaTemplate, WeatherService weatherService) {
        this.kafkaTemplate = kafkaTemplate;
        this.weatherService = weatherService;
    }

    @Scheduled(fixedRate = 5000)
    public void sendWeather() {
        WeatherDto weatherDto = weatherService.getWeather();

        kafkaTemplate.send("weather-topic", weatherDto);

        LOGGER.info("\nSend weather message to topic: {}\n", weatherDto.toString());
    }
}
