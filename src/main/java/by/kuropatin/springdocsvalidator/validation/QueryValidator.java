package by.kuropatin.springdocsvalidator.validation;

import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.query.Query;
import by.kuropatin.springdocsvalidator.query.QueryType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class QueryValidator<T extends ParamValidator> {

    protected final Map<ParamId, T> paramValidator;

    protected QueryValidator(final List<T> paramValidator) {
        this.paramValidator = paramValidator.stream()
                .collect(Collectors.toConcurrentMap(ParamValidator::getParamId, v -> v));
    }

    public abstract QueryType getQueryType();

    public final boolean isValid(final Query query) {
        if (query == null || query.getParams().isEmpty()) {
            return false;
        }
        paramValidator.values().forEach(validator -> validator.isValid(query));
        return query.isValid();
    }
}