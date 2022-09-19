package ru.job4j.early;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void whenLessThanEight() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("pass"));
        assertThat(exception.getMessage()).isEqualTo("Your password must be 8-32 characters long");
    }

    @Test
    public void whenLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("password"));
        assertThat(exception.getMessage()).isEqualTo("Your password must must contain at least one upper case character");
    }

    @Test
    public void whenUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("PASSWORD"));
        assertThat(exception.getMessage()).isEqualTo("Your password must contain at least one lower case character");
    }

    @Test
    public void whenNoDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("Password"));
        assertThat(exception.getMessage()).isEqualTo("Your password must contain at least one digit");
    }

    @Test
    public void whenNoSpecials() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("Password1"));
        assertThat(exception.getMessage()).isEqualTo("Your password must contain at least one special symbol");
    }
}