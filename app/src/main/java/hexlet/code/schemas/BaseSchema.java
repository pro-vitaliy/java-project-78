package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>> validationRules = new LinkedHashMap<>();
    private boolean isRequired;

    /**
     * Validates the given value against all registered validation rules.
     *
     * <p>This method checks the provided value against each predicate in the
     * {@code validationRules} map. If all predicates pass, the method returns
     * {@code true}, indicating that the value is valid. If any predicate fails,
     * it returns {@code false}.</p>
     *
     * @param value the value to be validated against the registered rules
     * @return {@code true} if the value passes all validation rules; {@code false} otherwise
     */
    public boolean isValid(T value) {
        if (!isRequired && !validationRules.get("required").test(value)) {
            return true;
        }
        return validationRules.values()
                .stream()
                .allMatch(p -> p.test(value));
    }

    protected final void addValidationRule(String ruleName, Predicate<T> pr) {
        validationRules.put(ruleName, pr);
    }

    protected final void markAsRequired() {
        this.isRequired = true;
    }
}
