package by.kuropatin.springdocsvalidator.validation.query;

import by.kuropatin.springdocsvalidator.query.QueryType;
import by.kuropatin.springdocsvalidator.validation.QueryValidator;
import by.kuropatin.springdocsvalidator.validation.Validation;
import by.kuropatin.springdocsvalidator.validation.param.query1.Q1ParamValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Validation
public class Q1Validator extends QueryValidator<Q1ParamValidator> {

    @Autowired
    public Q1Validator(final List<Q1ParamValidator> paramValidator) {
        super(paramValidator);
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.Q1;
    }
}