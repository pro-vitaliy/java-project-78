package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        Predicate<Integer> numNonNull = Objects::nonNull;
        addValidationRule("required", numNonNull);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> numIsPositive = n -> !Objects.nonNull(n) || n > 0;
        addValidationRule("positive", numIsPositive);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Integer> numInRange = n -> !Objects.nonNull(n) || (n >= begin && n <= end);
        addValidationRule("range", numInRange);
        return this;
    }

}
