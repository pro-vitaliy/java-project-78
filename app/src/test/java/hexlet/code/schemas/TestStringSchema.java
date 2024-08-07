package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringSchema {
    public static Validator validator;
    public static StringSchema schema;

    @BeforeAll
    public static void beforeAll() {
        validator = new Validator();
        schema = validator.string();
    }
    @Test
    void voidTest() {
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
