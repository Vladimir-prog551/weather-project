package org.example.consumer.handler;

import org.example.dto.WeatherDto;
import org.example.consumer.service.WeatherStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "weather-topic")
public class WeatherConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final WeatherStat weatherStat;

    public WeatherConsumer(WeatherStat weatherStat) {
        this.weatherStat = weatherStat;
    }

    @KafkaHandler
    public void handle(WeatherDto weatherDto) {
        weatherStat.addWeatherData(weatherDto);
        System.out.println("\n----------Weather----------");
        System.out.println("Город: " + weatherDto.getCity());
        System.out.println("Погода: " + weatherDto.getWeatherCondition());
        System.out.println("Температура: " + weatherDto.getTemperature());
        System.out.println("Дата: " + weatherDto.getLocalDate());
        System.out.println("---------------------------\n");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getStat() {
        System.out.println("\n\n\t\tСтатистика");
        System.out.println(weatherStat.findTheHottestDay());
        System.out.println(weatherStat.findMaxRainyDaysInCities());
        System.out.println("\n\n");
    }
}
