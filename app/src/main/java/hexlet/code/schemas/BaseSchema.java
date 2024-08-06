package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>> validationRules = new HashMap<>();

    public boolean isValid(T value) {
        return validationRules.values()
                .stream()
                .allMatch(p -> p.test(value));
    }

    protected void addValidationRule(String ruleName, Predicate<T> pr) {
        validationRules.put(ruleName, pr);
    }
}
