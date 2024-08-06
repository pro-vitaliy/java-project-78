package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        Predicate<Map<?, ?>> notNull = Objects::nonNull;
        addValidationRule("required", notNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> isSizeOf = m -> !Objects.nonNull(m) || m.size() == size;
        addValidationRule("sizeof", isSizeOf);
        return this;
    }
}
