package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapSchema {
    private Validator validator;

    @BeforeEach
    public void beforeEach() {
        validator = new Validator();
    }

    @Test
    public void isValidTest() {
        MapSchema<String, String> schema = validator.map();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void shapeTest() {
        MapSchema<String, String> schema1 = validator.map();
        Map<String, BaseSchema<String>> strSchemas = new HashMap<>();

        strSchemas.put("firstName", validator.string().required());
        strSchemas.put("lastName", validator.string().required().minLen(2));

        schema1.shape(strSchemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema1.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema1.isValid(human2));

        MapSchema<String, Integer> schema2 = validator.map();
        Map<String, BaseSchema<Integer>> intSchemas = new HashMap<>();

        intSchemas.put("firstHuman", validator.number().required().positive().range(18, 30));
        intSchemas.put("secondHuman", validator.number().required().positive());
        schema2.shape(intSchemas);

        Map<String, Integer> ageHumans = new HashMap<>();
        ageHumans.put("firstHuman", 20);
        assertTrue(schema2.isValid(ageHumans));
        ageHumans.put("secondHuman", -18);
        assertFalse(schema2.isValid(ageHumans));

    }
}
