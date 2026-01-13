package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FelineTest {


    @Test
    @DisplayName("Кошки едят мясо")
    void eatMeatReturnFoodListFeline() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        List<String> actual = feline.eatMeat();
        assertEquals(expected,actual, "Некорректный список еды для cемейства кошачьих");
    }


    @Test
    @DisplayName("Корректное название семейства Кошачьи")
    void getFamilyNameEqualsFeline() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual, "Семейство " + expected + " должно быть равным " + actual);
    }


    @Test
    @DisplayName("Семейство не равно значению Псовые")
    void getFamilyNotEqualsFeline() {
        Feline feline = new Feline();
        String expected = "Псовые";
        String actual = feline.getFamily();
        assertNotEquals(expected, actual, "Семейство " + expected + " не должно быть равным " + actual);
    }


    @Test
    @DisplayName("Метод getKittens() возвращает 1")
    void getKittensReturnsOne() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected,actual,"Количество котят " + expected + " не совпадает с " + actual);
    }

}