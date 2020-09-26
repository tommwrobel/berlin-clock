package com.tom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BerlinClockTest {

    private BerlinClock berlinClock;

    @BeforeEach
    void beforeEachMethod() {
        this.berlinClock = new BerlinClock();
    }

    @ParameterizedTest
    @CsvSource({"18:26:15,O:RRRO:RRRO:YYRYYOOOOOO:YOOO",
            "00:00:00,Y:OOOO:OOOO:OOOOOOOOOOO:OOOO",
            "13:17:01,O:RROO:RRRO:YYROOOOOOOO:YYOO",
            "23:59:59,O:RRRR:RRRO:YYRYYRYYRYY:YYYY",
            "15:25:15,O:RRRO:OOOO:YYRYYOOOOOO:OOOO"})
    void shouldReturnValidString(String givenTime, String expectedBerlinTime) {
        String actualBerlinTime = berlinClock.getBerlinTime(givenTime);

        assertEquals(expectedBerlinTime, actualBerlinTime);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:1:1", "30:24:12", "111:22:12", "0:0:0", "15"})
    void shouldThrowExceptionWhenGivenWrongTimeFormat(String givenTime) {
        assertThrows(IllegalArgumentException.class, () -> berlinClock.getBerlinTime(givenTime));
    }
}