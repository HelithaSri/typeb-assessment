package dev.helitha.typeb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldServiceTest {

    private HelloWorldService helloWorldService;

    @BeforeEach
    void setUp() {
        helloWorldService = new HelloWorldService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Alice", "Helitha", "Lavinda", "Mayura", "amila", "helitha", "lavinda", "mayura"})
    void shouldReturnTrueFroValidName(String name) {
        assertTrue(helloWorldService.checkValidity(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Nimal", "Praveen", "Randika", "Sonal", "nimal", "praveen", "randika", "sonal"})
    void shouldReturnFalseFroInvalidName(String name) {
        assertFalse(helloWorldService.checkValidity(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n", "-", "?"})
    void shouldReturnFalseFroNullOrBlankOrSpecialCharName(String name) {
        assertFalse(helloWorldService.checkValidity(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1Alice", "@Alice", "_John",
            "#Michael", "12345"
    })
    void shouldReturnFalseForSpecialCharacters(String name) {
        assertFalse(helloWorldService.checkValidity(name));
    }

    @Test
    void shouldAcceptSingleLetterA() {
        assertTrue(helloWorldService.checkValidity("A"));
    }

    @Test
    void shouldAcceptSingleLetterM() {
        assertTrue(helloWorldService.checkValidity("M"));
    }

    @Test
    void shouldRejectSingleLetterN() {
        assertFalse(helloWorldService.checkValidity("N"));
    }

    @Test
    void shouldRejectSingleLetterZ() {
        assertFalse(helloWorldService.checkValidity("Z"));
    }

    @Test
    void shouldHandleLeadingAndTrailingSpaces() {
        assertTrue(helloWorldService.checkValidity("  Alice  "));
    }

}
