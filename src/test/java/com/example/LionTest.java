package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @Test
    @DisplayName("Метод getKittens() возвращает значение из класса feline")
    void getKittensFromFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(9);
        Lion lion = new Lion(feline,"Самец");
        int expected = 9;
        int actual = lion.getKittens();
        assertEquals(expected,actual,"Количество котят " + expected + " не равно " + actual);
        Mockito.verify(feline).getKittens();
    }

    @Test
    @DisplayName("Львы употребляют в пищу мясо")
    void getFoodEqualsLion() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion(feline,"Самец");
        List<String> actual = lion.getFood();
        assertEquals(expected,actual, "Неверный список еды для льва");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    @DisplayName("У самца льва есть грива")
    void hasManeForMaleLion() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        boolean actual = lion.doesHaveMane();
        assertTrue(actual,"У самца льва должна быть грива");
    }

    @Test
    @DisplayName("У самки льва нет гривы")
    void hasNotManeForFemaleLion() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        boolean actual = lion.doesHaveMane();
        assertFalse(actual,"У самки льва не должно быть гривы");
    }

    @Test
    @DisplayName("При некорректных данных срабатывает exception")
    void triggeredThrowsException() throws Exception {
        assertThrows(Exception.class ,() -> new Lion(feline,"Лигр"), "Должен сработать Exception для неккоректных данных");
    }

}