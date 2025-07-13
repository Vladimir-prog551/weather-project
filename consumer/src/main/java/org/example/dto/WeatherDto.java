package org.example.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.consumer.enums.CityEnum;
import org.example.consumer.enums.WeatherCondition;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

    private CityEnum city;
    private Integer temperature;
    private WeatherCondition weatherCondition;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate localDate;
}
