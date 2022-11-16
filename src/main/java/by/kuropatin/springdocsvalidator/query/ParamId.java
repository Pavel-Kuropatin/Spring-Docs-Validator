package by.kuropatin.springdocsvalidator.query;

import lombok.Getter;

@Getter
public enum ParamId {

    ACCOUNT("Account"),
    AMOUNT("Amount"),
    CURRENCY("Currency"),
    DATE("Date"),
    DOC_TYPE("DocType"),
    NUM("Num");

    private final String id;

    ParamId(final String id) {
        this.id = id;
    }
}