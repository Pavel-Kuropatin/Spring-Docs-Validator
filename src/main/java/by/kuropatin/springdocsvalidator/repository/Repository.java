package by.kuropatin.springdocsvalidator.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Repository {

    public static List<String> getCurrencyList() {
        return Arrays.asList("933", "643", "840", "978");
    }

    public static List<String> getDocTypesList() {
        return Arrays.asList("0", "3", "5", "7");
    }
}