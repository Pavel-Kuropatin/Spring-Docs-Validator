package by.kuropatin.springdocsvalidator.validation.query;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.query.Query;
import by.kuropatin.springdocsvalidator.query.QueryStatus;
import by.kuropatin.springdocsvalidator.query.QueryType;
import by.kuropatin.springdocsvalidator.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Q1ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void isValid() {
        final Query query = new Query();
        query.setId(null);
        query.setType(QueryType.Q1);
        query.setStatus(QueryStatus.NEW);
        query.setDateIn(null);
        query.setDateOut(null);

        final ArrayList<Param> params = new ArrayList<>();
        params.add(new Param(ParamId.ACCOUNT.getId(), "Счёт", "BY99MMBN30120000000000000933"));
        params.add(new Param(ParamId.AMOUNT.getId(), "Сумма перевода", "123.45"));
        params.add(new Param(ParamId.CURRENCY.getId(), "Валюта", "933"));
        params.add(new Param(ParamId.DATE.getId(), "Дата документа", LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        params.add(new Param(ParamId.NUM.getId(), "Номер документа", "007"));

        query.getParams().addAll(params);

        final boolean isValid = validator.isValid(query);
        assertTrue(isValid);
    }

    @Test
    void loop() {
        final Query query = new Query();
        query.setId(null);
        query.setType(QueryType.Q1);
        query.setStatus(QueryStatus.NEW);
        query.setDateIn(null);
        query.setDateOut(null);

        final ArrayList<Param> params = new ArrayList<>();
        params.add(new Param(ParamId.ACCOUNT.getId(), "Счёт", "BY99MMBN30120000000000000933"));
        params.add(new Param(ParamId.AMOUNT.getId(), "Сумма перевода", "123.45"));
        params.add(new Param(ParamId.CURRENCY.getId(), "Валюта", "933"));
        params.add(new Param(ParamId.DATE.getId(), "Дата документа", LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        params.add(new Param(ParamId.NUM.getId(), "Номер документа", "007"));

        query.getParams().addAll(params);

        final StopWatch stopWatch = new StopWatch();
        System.out.println((Runtime.getRuntime().totalMemory() / 1024 / 1024));
        stopWatch.start();
        for (int i = 0; i < 10_000_000; i++) {
            validator.isValid(query);
        }
        stopWatch.stop();
        System.out.println((Runtime.getRuntime().totalMemory() / 1024 / 1024));

        System.out.println(stopWatch.getTotalTimeMillis() / 1000.0);
    }
}