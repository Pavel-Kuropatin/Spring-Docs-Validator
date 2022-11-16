package by.kuropatin.springdocsvalidator.validation.query;

import by.kuropatin.springdocsvalidator.query.QueryType;
import by.kuropatin.springdocsvalidator.validation.QueryValidator;
import by.kuropatin.springdocsvalidator.validation.Validation;
import by.kuropatin.springdocsvalidator.validation.param.query2.Q2ParamValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Validation
public class Q2Validator extends QueryValidator<Q2ParamValidator> {

    @Autowired
    public Q2Validator(final List<Q2ParamValidator> paramValidator) {
        super(paramValidator);
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.Q2;
    }
}