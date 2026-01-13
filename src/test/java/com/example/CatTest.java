package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class CatTest {

    @Mock
    Feline feline;


    @Test
    @DisplayName("Кот должен мяукать")
    void getSoundEqualsCat() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual,"Кот не мяукает");
    }


    @Test
    @DisplayName("Коты едят мясо")
    void getFoodEqualsCat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();
        assertEquals(expected,actual, "Неверный список еды ");
        Mockito.verify(feline).eatMeat();
    }
}