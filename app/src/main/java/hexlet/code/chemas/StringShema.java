package hexlet.code.chemas;


import java.util.ArrayList;
import java.util.List;

public class StringShema {
    private boolean isRequired;
    private String toContains;
    private int minLength;
    private final List<String> settings = new ArrayList<>();

    public boolean isValid(String text) {
        if (isRequired && (text == null || text.isEmpty())) {
            return false;
        }
        if (isRequired && settings.contains("contains") && toContains != null && !text.contains(toContains)) {
            return false;
        }
        if (isRequired && settings.contains("minLen") && text.length() < minLength) {
            return false;
        }
        return true;
    }

    public StringShema required() {
        this.isRequired = true;
        settings.add("required");
        return this;
    }

    public StringShema contains(String str) {
        this.toContains = str;
        settings.add("contains");
        return this;
    }

    public StringShema minLen(int len) {
        this.minLength = len;
        settings.add("minLen");
        return this;
    }
}
