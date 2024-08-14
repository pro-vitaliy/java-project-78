package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        Predicate<String> stringNonNull = Objects::nonNull;
        Predicate<String> stringNotEmpty = s -> !s.isEmpty();
        addValidationRule("required", stringNonNull.and(stringNotEmpty));
    }

    public StringSchema required() {
        markAsRequired();
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<String> isContains = s -> s.contains(str);
        addValidationRule("contains", isContains);
        return this;
    }

    public StringSchema minLength(int len) {
        Predicate<String> minLen = s -> s.length() >= len;
        addValidationRule("minLength", minLen);
        return this;
    }
}
