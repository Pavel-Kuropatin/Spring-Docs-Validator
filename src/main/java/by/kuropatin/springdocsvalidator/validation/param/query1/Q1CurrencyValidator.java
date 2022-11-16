package by.kuropatin.springdocsvalidator.validation.param.query1;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.repository.Repository;
import by.kuropatin.springdocsvalidator.validation.ErrorMessages;
import by.kuropatin.springdocsvalidator.validation.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

@Validation
public class Q1CurrencyValidator extends Q1ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.CURRENCY;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        if (StringUtils.isBlank(param.getValue())) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
        final List<String> allowedCurrency = Repository.getCurrencyList();
        if (!allowedCurrency.contains(param.getValue())) {
            setInvalid(param, ErrorMessages.NOT_VALID_WITH_ALLOWED_VALUES,
                    param.getName(), param.getId(), param.getValue(), allowedCurrency.toString());
        }
    }
}