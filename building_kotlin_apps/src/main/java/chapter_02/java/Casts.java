package chapter_02.java;

import java.util.List;

public class Casts {

    private int getSize(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).length();
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else if (obj instanceof List<?>) {
            return ((List) obj).size();
        }
        return 0;
    }
}
