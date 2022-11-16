package by.kuropatin.springdocsvalidator.validation.param.query2;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.validation.Validation;

import java.util.Map;

@Validation
public class Q2NumValidator extends Q2ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.NUM;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        validateNum(param);
    }
}