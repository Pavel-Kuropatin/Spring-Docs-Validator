package by.kuropatin.springdocsvalidator.validation;

import by.kuropatin.springdocsvalidator.query.Query;
import by.kuropatin.springdocsvalidator.query.QueryType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Validation
public class Validator {

    private final Map<QueryType, QueryValidator<? extends ParamValidator>> validatorMap;

    public Validator(final List<QueryValidator<? extends ParamValidator>> validatorList) {
        this.validatorMap = validatorList.stream()
                .collect(Collectors.toConcurrentMap(QueryValidator::getQueryType, queryValidator -> queryValidator));
    }

    public boolean isValid(final Query query) {
        final QueryValidator<? extends ParamValidator> queryValidator = validatorMap.get(query.getType());
        if (queryValidator == null) {
            throw new UnsupportedOperationException(String.format("Валидатор для документа типа %s не найден", query.getType()));
        }
        return queryValidator.isValid(query);
    }
}