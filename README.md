# **Веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site/)

## Часть 3. Тестирование UI**

Стек:
* Java 11
* Maven
* JUnit 4
* RestAssured
* Selenide
* Allure

Функциональность протестирована в Google Chrome и Яндекс.Браузере.
Перемена браузера происходит c помощью Maven c передачей системной переменной через команды
`mvn -DtestBrowser=CHROME test
mvn -DtestBrowser=YANDEX test`
или через Junit с передачей переменной через конфигурацию.

Проверены:
**Регистрация:**

* успешная регистрация
* ошибка для некорректного пароля (минимальный пароль – 6 символов)

**Вход:**

* вход по кнопке «Войти в аккаунт» на главной
* вход через кнопку «Личный кабинет»
* вход через кнопку в форме регистрации
* вход через кнопку в форме восстановления пароля

**Переходы:**

* переход по клику на «Личный кабинет»
* переход по клику на «Конструктор» и на логотип Stellar Burgers
* выход по кнопке «Выйти» в личном кабинете

**Переходы к разделам:**

* «Булки
* «Соусы»
* «Начинки»



