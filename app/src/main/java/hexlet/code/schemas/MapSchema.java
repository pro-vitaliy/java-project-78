package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> isSizeOf = m -> !Objects.nonNull(m) || m.size() == size;
        addValidationRule("sizeof", isSizeOf);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<Map<?, ?>> isShape = m -> m == null || m.keySet().stream()
                .allMatch(k -> schemas.get(k).isValid((T) m.get(k)));

        addValidationRule("shape", isShape);
        return this;
    }
}
