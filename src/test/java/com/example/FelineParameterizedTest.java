package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 33, 333})
    @DisplayName("Метод getKittens() с положительными числами")
    void testGetKittensWithPositiveNumbers(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual, "Количество котят " + kittensCount + " не совпадает с результатом " + actual);
    }


    @ParameterizedTest
    @ValueSource(ints = {-7, -77, -777})
    @DisplayName("Метод getKittens() с отрицательными числами")
    void testGetKittensWithNegativeNumbers(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual, "Отрицательное количество котят " + kittensCount + " не обрабатывается методом ");
    }
}
