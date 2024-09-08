package org.ibs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {


    @Test
    void addProductWithHardNameTest() {
        // Устанавливаем базовый URI
        RestAssured.baseURI = "http://localhost:8080";

        String requestBody = "{ \"name\": \"dghj%:*ГўвЂћвЂ“5ГђВїГђВ°ГђВІГђВ»ГђВї\", \"type\": \"VEGETABLE\", \"exotic\": \"true\" }"; // пример данных, которые вы хотите отправить

        // Выполняем POST-запрос на добавление продукта
        Response response = given()
                .header("Content-Type", "application/json") // Указываем, что отправляем JSON
                .body(requestBody) // Тело запроса
                .when()
                .log()
                .all() // Логируем запрос и ответ
                .post("/api/food"); // Путь к API для добавления продукта

        // Проверяем статус ответа
        Assertions.assertEquals(200, response.statusCode()); // Обычно для успешного добавления возвращается статус 201
    }

    @Test
    void addExoticFruitTestWithEmptyName() {
        // Устанавливаем базовый URI
        RestAssured.baseURI = "http://localhost:8080";

        String requestBody = "{ \"name\": \"\", \"type\": \"FRUIT\", \"exotic\": \"true\" }"; // пример данных, которые вы хотите отправить

        // Выполняем POST-запрос на добавление продукта
        Response response = given()
                .header("Content-Type", "application/json") // Указываем, что отправляем JSON
                .body(requestBody) // Тело запроса
                .when()
                .log()
                .all() // Логируем запрос и ответ
                .post("/api/food"); // Путь к API для добавления продукта

        // Проверяем статус ответа
        Assertions.assertEquals(200, response.statusCode()); // Обычно для успешного добавления возвращается статус 201
    }

}
