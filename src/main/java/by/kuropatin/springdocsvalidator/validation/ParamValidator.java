package by.kuropatin.springdocsvalidator.validation;

import by.kuropatin.springdocsvalidator.query.Param;
import by.kuropatin.springdocsvalidator.query.ParamId;
import by.kuropatin.springdocsvalidator.query.Query;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ParamValidator {

    public final boolean isValid(final Query query) {
        final Param validated = query.findParam(getParamId());
        validateParam(validated, getQueryParams(query));
        return validated.isValid();
    }

    protected abstract ParamId getParamId();

    protected abstract void validateParam(final Param param, final Map<String, Param> context);

    private Map<String, Param> getQueryParams(final Query query) {
        return query.getParams().stream()
                .collect(Collectors.toMap(Param::getId, Param::new));
    }

    protected void validateNum(final Param param) {
        try {
            Integer.parseInt(param.getValue());
        } catch (NumberFormatException e) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
    }

    protected void validateDateNullable(final Param param) {
        if (StringUtils.isBlank(param.getValue())) {
            return;
        }
        try {
            LocalDate.parse(param.getValue(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (NumberFormatException e) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
    }

    protected void validateDateNotNullable(final Param param) {
        try {
            LocalDate.parse(param.getValue(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            setInvalid(param, ErrorMessages.INCORRECT_FORMAT_OR_EMPTY);
        }
    }

    protected void setInvalid(final Param param, final ErrorMessages message) {
        setInvalid(param, message, param.getName(), param.getId());
    }

    protected void setInvalid(final Param param, final ErrorMessages message, final Object... params) {
        param.setValid(false);
        param.setErrorMessage(String.format(message.getMessage(), params));
    }
}