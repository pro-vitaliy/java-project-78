package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        Predicate<Integer> numNotNull = Objects::nonNull;
        addValidationRule("required", numNotNull);
    }

    public NumberSchema required() {
        markAsRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> numIsPositive = n -> n > 0;
        addValidationRule("positive", numIsPositive);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Integer> numInRange = n -> n >= begin && n <= end;
        addValidationRule("range", numInRange);
        return this;
    }

}
