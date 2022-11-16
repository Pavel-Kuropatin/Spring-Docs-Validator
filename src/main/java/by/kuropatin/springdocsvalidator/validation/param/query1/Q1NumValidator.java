package by.kuropatin.springdocsvalidator.validation.param.query1;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.validation.Validation;

import java.util.Map;

//@Order(1)
@Validation
public class Q1NumValidator extends Q1ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.NUM;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        validateNum(param);
    }
}