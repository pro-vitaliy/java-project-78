package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    public MapSchema<K, V> required() {
        Predicate<Map<K, V>> notNull = Objects::nonNull;
        addValidationRule("required", notNull);
        return this;
    }

    public MapSchema<K, V> sizeof(int size) {
        Predicate<Map<K, V>> isSizeOf = m -> !Objects.nonNull(m) || m.size() == size;
        addValidationRule("sizeof", isSizeOf);
        return this;
    }

    public MapSchema<K, V> shape(Map<K, BaseSchema<V>> schema) {

        Predicate<Map<K, V>> isShape = m -> m.keySet().stream()
                .allMatch(k -> schema.get(k).isValid(m.get(k)));

        addValidationRule("shape", isShape);
        return this;
    }
}
