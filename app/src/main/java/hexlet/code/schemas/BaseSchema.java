package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>> validationRules = new HashMap<>();

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
        return validationRules.values()
                .stream()
                .allMatch(p -> p.test(value));
    }

    /**
     * Adds a validation rule to ensure that the value is not null.
     *
     * <p>This method registers a predicate that checks if the given value
     * is not null. If the value is null, the validation will fail.</p>
     *
     * @return the current schema with the added non-null validation rule.
     */
    public BaseSchema<T> required() {
        Predicate<T> isRequired = Objects::nonNull;
        addValidationRule("required", isRequired);
        return this;
    }

    protected final void addValidationRule(String ruleName, Predicate<T> pr) {
        validationRules.put(ruleName, pr);
    }
}
