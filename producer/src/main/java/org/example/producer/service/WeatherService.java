package org.example.producer.service;

import org.example.dto.WeatherDto;
import org.example.producer.enums.CityEnum;
import org.example.producer.enums.WeatherCondition;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class WeatherService {

    private final Random random = new Random();

    public WeatherDto getWeather() {
        return new WeatherDto(
                getRandomCity(),
                getRandomTemperature(),
                getRandomCondition(),
                LocalDate.now()
        );
    }

    private CityEnum getRandomCity() {
        return CityEnum.values()[random.nextInt(CityEnum.values().length)];
    }

    private Integer getRandomTemperature() {
        return random.nextInt(35);
    }

    private WeatherCondition getRandomCondition() {
        return WeatherCondition.values()[random.nextInt(WeatherCondition.values().length)];
    }
}
