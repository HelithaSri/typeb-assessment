package dev.helitha.typeb.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class HelloWorldService {
    private static final List<Character> VALID_LETTERS = List.of(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'
    );

    public boolean checkValidity(String name) {
        if (!StringUtils.hasText(name)) {
            return false;
        }

        name = name.trim();
        char firstLetter = Character.toUpperCase(name.charAt(0));

        return VALID_LETTERS.contains(firstLetter);
    }
}
