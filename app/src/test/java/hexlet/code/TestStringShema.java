package hexlet.code;

import hexlet.code.chemas.StringShema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringShema {
    public static Validator validator;
    public static StringShema shema;

    @BeforeAll
    public static void beforeAll() {
        validator = new Validator();
        shema = validator.string();
    }
    @Test
    void voidTest() {
        assertTrue(shema.isValid(""));
        assertTrue(shema.isValid(null));

        shema.required();
        assertFalse(shema.isValid(""));
        assertFalse(shema.isValid(null));

        shema.minLen(2);
        assertFalse(shema.isValid("1"));
        assertTrue(shema.isValid("11"));

        shema.contains("ex");
        assertTrue(shema.isValid("hexlet"));
        assertFalse(shema.isValid("xlet"));
    }
}
