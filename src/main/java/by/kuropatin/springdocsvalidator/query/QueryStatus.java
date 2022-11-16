package by.kuropatin.springdocsvalidator.query;

import lombok.Getter;

@Getter
public enum QueryStatus {

    NEW(1),
    SIGNED(2),
    SENT(3),
    ACCEPTED(4),
    DECLINED(5);

    private final int id;

    QueryStatus(final int id) {
        this.id = id;
    }
}