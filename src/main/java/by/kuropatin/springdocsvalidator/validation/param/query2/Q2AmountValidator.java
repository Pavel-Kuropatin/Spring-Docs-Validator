package by.kuropatin.springdocsvalidator.validation.param.query2;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.validation.ErrorMessages;
import by.kuropatin.springdocsvalidator.validation.Validation;

import java.math.BigDecimal;
import java.util.Map;

@Validation
public class Q2AmountValidator extends Q2ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.AMOUNT;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        try {
            final BigDecimal amount = new BigDecimal(param.getValue());
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                setInvalid(param, ErrorMessages.AMOUNT_MUST_BE_BIGGER_THAN_ZERO);
            }
        } catch (NumberFormatException e) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
    }
}