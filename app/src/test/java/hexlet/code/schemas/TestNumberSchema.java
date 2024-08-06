package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberSchema {
    public static Validator validator;
    public static NumberSchema schema;

    @BeforeAll
    public static void beforeAll() {
        validator = new Validator();
        schema = validator.number();
    }

    @Test
    public void isValidTest() {
        assertTrue(schema.isValid(null));

        schema.positive();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(11));
        assertFalse(schema.isValid(4));
    }
}
