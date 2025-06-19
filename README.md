# Система керування квитками автобусної станції

Цей проєкт є реалізацією RESTful API для керування квитками на автобусній станції. Система дозволяє створювати, переглядати, редагувати та видаляти квитки, а також здійснювати пошук за різними параметрами.

## Технології
- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- MySQL
- Hibernate
- Postman (для тестування API)

## Модель квитка

Кожен квиток має наступні поля:
- `id`: унікальний ідентифікатор
- `tripDate`: дата рейсу
- `tripName`: назва рейсу
- `busNumber`: номер автобуса
- `price`: ціна квитка
- `seat`: місце в автобусі
- `departureTime`: час відправлення

## API ендпоінти

Основні доступні запити:

| Метод | Шлях | Опис |
|-------|------|------|
| `POST` | `/api/v1/tickets` | Створити новий квиток |
| `GET` | `/api/v1/tickets` | Отримати всі квитки |
| `GET` | `/api/v1/tickets/{id}` | Отримати квиток за `id` |
| `PUT` | `/api/v1/tickets/{id}` | Повністю оновити квиток |
| `PATCH` | `/api/v1/tickets/{id}` | Частково оновити квиток |
| `DELETE` | `/api/v1/tickets/{id}` | Видалити квиток за `id` |
| `DELETE` | `/api/v1/tickets/deleteAll` | Видалити всі квитки |
| `GET` | `/api/v1/tickets/search/byTripName?tripName=...` | Пошук за назвою рейсу |
| `GET` | `/api/v1/tickets/search/byDepartureTime?departureTime=...` | Пошук за часом відправлення |
| `GET` | `/api/v1/tickets/search/byBusNumber?busNumber=...` | Пошук за номером автобуса |

## Налаштування

1. Створіть базу даних MySQL (наприклад, `bus_station`)
2. Встановіть параметри з'єднання у `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bus_station
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```
   (Приклад файлу наведений у [application-example.properties](src/main/resources/application-example.properties))
3. Запустіть проєкт у середовищі, яке підтримує Spring Boot (наприклад, IntelliJ IDEA)

## Автор

Розроблено як частина практики зі спеціальності "Комп'ютерні науки", ПНУ ім. Василя Стефаника, 2025.