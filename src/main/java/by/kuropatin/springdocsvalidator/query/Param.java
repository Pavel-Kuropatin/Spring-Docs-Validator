package by.kuropatin.springdocsvalidator.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Param {

    private String id;
    private String name;
    private String value;
    private boolean isValid;
    private String errorMessage;

    public Param(final String id, final String value) {
        this.id = id;
        this.name = "";
        this.value = value;
        this.isValid = true;
        this.errorMessage = "";
    }

    public Param(final String id, final String name, final String value) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.isValid = true;
        this.errorMessage = "";
    }

    public Param(final Param param) {
        this.id = param.getId();
        this.name = param.getName();
        this.value = param.getValue();
        this.isValid = param.isValid();
        this.errorMessage = param.getErrorMessage();
    }

    public static Param empty() {
        return new Param("", "", "", true, "");
    }

    public static Param empty(final String id) {
        return new Param(id, "", "", true, "");
    }
}