package by.kuropatin.springdocsvalidator.validation.param.query1;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.validation.ErrorMessages;
import by.kuropatin.springdocsvalidator.validation.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Validation
public class Q1AccountValidator extends Q1ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.ACCOUNT;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        if (StringUtils.isBlank(param.getValue())) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
            return;
        }
        if (param.getValue().length() != 28) {
            setInvalid(param, ErrorMessages.AMOUNT_MUST_BE_BIGGER_THAN_ZERO, param.getName(), param.getId(), param.getValue());
        }
    }
}