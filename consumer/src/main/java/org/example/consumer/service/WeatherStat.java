package org.example.consumer.service;

import org.example.dto.WeatherDto;
import org.example.consumer.enums.WeatherCondition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WeatherStat {

    private final Map<String, List<WeatherDto>> weatherData = new ConcurrentHashMap<>();

    public void addWeatherData(WeatherDto weatherDto) {
        weatherData.computeIfAbsent(
                String.valueOf(weatherDto.getCity()),
                k -> new ArrayList<>()
        ).add(weatherDto);
    }

    public String findTheHottestDay() {
        return weatherData.values().stream()
                .flatMap(List::stream)
                .max(Comparator.comparing(WeatherDto::getTemperature))
                .map(dto -> "Самый жаркий день\n\t%s\n\t%s\n\t%d".formatted(
                        dto.getLocalDate(),
                        dto.getCity(),
                        dto.getTemperature()))
                .orElse("нет данных");
    }

    public String findMaxRainyDaysInCities() {
        return weatherData.entrySet().stream()
                .map(entry -> Map.entry(
                        entry.getKey(),
                        entry.getValue().stream()
                                .filter(dto -> dto.getWeatherCondition() == WeatherCondition.RAINY)
                                .count()
                ))
                .max(Map.Entry.comparingByValue())
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> "Больше всего дождей в %s (%d дней)"
                        .formatted(entry.getKey(), entry.getValue()))
                .orElse("нет данных");
    }
}
