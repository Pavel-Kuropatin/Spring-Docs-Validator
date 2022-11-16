package by.kuropatin.springdocsvalidator.validation.param.query1;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.validation.Validation;

import java.util.Map;

@Validation
public class Q1DateValidator extends Q1ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.DATE;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        validateDateNotNullable(param);
    }
}