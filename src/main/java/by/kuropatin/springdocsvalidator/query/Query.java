package by.kuropatin.springdocsvalidator.query;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Query {

    private Long id;
    private QueryType type;
    private QueryStatus status;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;
    @Setter(value = AccessLevel.NONE)
    private List<Param> params;

    public List<Param> getParams() {
        if (params == null) {
            this.params = new ArrayList<>();
        }
        return params;
    }

    public Param findParam(final ParamId paramId) {
        if (paramId == null || paramId.getId() == null || paramId.getId().isEmpty()) {
            return Param.empty();
        }

        return params.stream()
                .filter(param -> paramId.getId().equals(param.getId()))
                .findFirst()
                .orElseGet(() -> {
                    final Param empty = Param.empty(paramId.getId());
                    params.add(empty);
                    return empty;
                });
    }

    public String findParamValue(final ParamId paramId) {
        return findParam(paramId).getValue();
    }

    public boolean isValid() {
        if (type == null || params == null || params.isEmpty()) {
            return false;
        }
        return params.stream().allMatch(Param::isValid);
    }
}