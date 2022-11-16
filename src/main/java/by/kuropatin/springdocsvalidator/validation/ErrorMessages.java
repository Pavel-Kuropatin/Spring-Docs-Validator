package by.kuropatin.springdocsvalidator.validation;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ACCOUNT_NOT_VALID("Параметр '%s' (%s) имеет не корректное значение '%s'"),
    AMOUNT_MUST_BE_BIGGER_THAN_ZERO("Параметр '%s' (%s) должен быть больше 0"),
    INCORRECT_FORMAT_OR_EMPTY("Параметр '%s' (%s) не задан или имеет некорректное значение"),
    NOT_VALID_WITH_ALLOWED_VALUES("Параметр '%s' (%s) имеет недопустимое значение (%s). Допустимые значения: (%s)");

    private final String message;

    ErrorMessages(final String message) {
        this.message = message;
    }
}