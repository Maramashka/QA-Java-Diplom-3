# Automation QA Java UI

Автотесты для проверки UI веб-приложения [**Stellar Burgers**](https://stellarburgers.nomoreparties.site/)

Тестовые данные создаются и удаляются через API: [**документация API**](https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf)

### Задачи
* Протестировать необходимую функциональность
* Подключить браузеры Google Chrome и Яндекс.Браузер
* Использовать Page Object
* Сформировать отчёт Allure

Перемена браузера происходит c помощью Maven c передачей системной переменной через команды
`mvn -DtestBrowser=CHROME test
mvn -DtestBrowser=YANDEX test`
или через Junit с передачей переменной через конфигурацию.

## Стек
* Java 11
* Maven 4.0.0
* JUnit 4.13.2
* RestAssured 5.3.0
* Selenide 6.19.1
* Gson 2.10.1
* Lombok 1.18.26
* Allure 2.20.1

## Запуск тестов и построение отчёта
mvn clean test
mvn allure:serve





