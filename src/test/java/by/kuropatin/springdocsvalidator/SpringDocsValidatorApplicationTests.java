package by.kuropatin.springdocsvalidator;

import by.kuropatin.springdocsvalidator.validation.param.query1.Q1AccountValidator;
import by.kuropatin.springdocsvalidator.validation.param.query1.Q1AmountValidator;
import by.kuropatin.springdocsvalidator.validation.param.query1.Q1CurrencyValidator;
import by.kuropatin.springdocsvalidator.validation.param.query1.Q1DateValidator;
import by.kuropatin.springdocsvalidator.validation.param.query1.Q1NumValidator;
import by.kuropatin.springdocsvalidator.validation.param.query2.Q2AmountValidator;
import by.kuropatin.springdocsvalidator.validation.param.query2.Q2DateValidator;
import by.kuropatin.springdocsvalidator.validation.param.query2.Q2DocTypeValidator;
import by.kuropatin.springdocsvalidator.validation.param.query2.Q2NumValidator;
import by.kuropatin.springdocsvalidator.validation.query.Q1Validator;
import by.kuropatin.springdocsvalidator.validation.query.Q2Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringDocsValidatorApplicationTests {

    @Autowired
    private Q1AccountValidator q1AccountValidator;

    @Autowired
    private Q1AmountValidator q1AmountValidator;

    @Autowired
    private Q1CurrencyValidator q1CurrencyValidator;

    @Autowired
    private Q1DateValidator q1DateValidator;

    @Autowired
    private Q1NumValidator q1NumValidator;

    @Autowired
    private Q2AmountValidator q2AmountValidator;

    @Autowired
    private Q2DateValidator q2DateValidator;

    @Autowired
    private Q2DocTypeValidator q2DocTypeValidator;

    @Autowired
    private Q2NumValidator q2NumValidator;

    @Autowired
    private Q1Validator q1Validator;

    @Autowired
    private Q2Validator q2Validator;

    @Test
    void contextLoads() {
        assertNotNull(q1AccountValidator);
        assertNotNull(q1AmountValidator);
        assertNotNull(q1CurrencyValidator);
        assertNotNull(q1DateValidator);
        assertNotNull(q1NumValidator);
        assertNotNull(q2AmountValidator);
        assertNotNull(q2DateValidator);
        assertNotNull(q2DocTypeValidator);
        assertNotNull(q2NumValidator);
        assertNotNull(q1Validator);
        assertNotNull(q2Validator);
    }
}