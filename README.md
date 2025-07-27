# Weather Monitoring System with Kafka

[![Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=flat&logo=apache-kafka&logoColor=white)]()
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white)]()
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)]()

Микросервисная система для сбора и анализа данных о погоде в реальном времени с использованием Apache Kafka.

## Функционал

**Producer Service:**
- генерирует случайные данные о погоде (город, температура, условия) каждые 5 секунд;
- отправляет данные в Kafka-топик `weather-topic`.

**Consumer Service:**
- получает данные из Kafka;
- выводит информацию о каждой погодной записи;
- формирует статистику:
  - самый жаркий день;
  - город с наибольшим количеством дождливых дней.

## Технологии

- **Apache Kafka** (бинарный протокол KRaft);
- **Spring Boot 3** (Spring Kafka, Spring Scheduling);
- **Java 17**;
- **Docker** + **Docker Compose**;
- **Lombok** для сокращения boilerplate-кода;
- **Jackson** для JSON-сериализации.

## Запуск проекта

1. Клонируйте репозиторий:
   ```
   git clone https://github.com/Vladimir-prog551/weather-project.git
   cd weather-project
   ```
2. Запустите все сервисы через Docker Compose
   ```
   docker-compose up --build
   ```

## Работа сервисов

Пример работы продюсера:
```
producer-1  | 2025-07-27T09:16:18.571Z  INFO 1 --- [producer] [   scheduling-1]
o.e.producer.service.WeatherProducer     :
producer-1  | Send weather message to topic:
producer-1  | WeatherDto(city=VLADIVOSTOK, temperature=10, weatherCondition=RAINY, localDate=2025-07-27)
```
Пример работы консюмера:
```
consumer-1  | ----------Weather----------
consumer-1  | Город: SEVASTOPOL
consumer-1  | Погода: CLOUDY
consumer-1  | Температура: 6
consumer-1  | Дата: 2025-07-27
consumer-1  | ---------------------------

consumer-1  |           Статистика
consumer-1  | Самый жаркий день
consumer-1  |   2025-07-27
consumer-1  |   SEVASTOPOL
consumer-1  |   34
consumer-1  | Больше всего дождей в SEVASTOPOL (6 дней)
```
