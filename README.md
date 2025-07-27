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
   git clone https://github.com/ваш-репозиторий.git
   cd weather-kafka-system
   ```
2. Запустите все сервисы через Docker Compose
   ```
   docker-compose up --build
   ```
