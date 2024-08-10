package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringSchema {

    @Test
    void isValidTest() {
        Validator validator = new Validator();
        var schema = validator.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.minLength(5);
        assertTrue(schema.isValid("12345"));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        schema.minLength(2);
        assertFalse(schema.isValid("1"));
        assertTrue(schema.isValid("11"));

        schema.contains("ex");
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("xlet"));
    }
}
