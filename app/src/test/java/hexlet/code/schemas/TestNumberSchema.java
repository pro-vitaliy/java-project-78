package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestNumberSchema {

    @Test
    public void isValidTest() {
        Validator validator = new Validator();
        var schema = validator.number();

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
