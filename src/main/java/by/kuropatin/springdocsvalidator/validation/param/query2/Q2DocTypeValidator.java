package by.kuropatin.springdocsvalidator.validation.param.query2;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.repository.Repository;
import by.kuropatin.springdocsvalidator.validation.ErrorMessages;
import by.kuropatin.springdocsvalidator.validation.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

@Validation
public class Q2DocTypeValidator extends Q2ParamValidator {

    @Override
    protected ParamId getParamId() {
        return ParamId.DOC_TYPE;
    }

    @Override
    protected void validateParam(final Param param, final Map<String, Param> context) {
        if (StringUtils.isBlank(param.getValue())) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
        final List<String> allowedTypes = Repository.getDocTypesList();
        if (!allowedTypes.contains(param.getValue())) {
            setInvalid(param, ErrorMessages.NOT_VALID_WITH_ALLOWED_VALUES,
                    param.getName(), param.getId(), param.getValue(), allowedTypes.toString());
        }
    }
}