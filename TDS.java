
import java.util.*;

public class TDS {

    private Map<String, Type> vars = new HashMap<>();
    private static TDS instance = new TDS();

    public TDS() {}

    public static TDS getInstance() {
        return instance;
    } 

    public String identifier(String entry) {
        return this.vars.get(entry).toString();
    }

    public static void put(String key, Type value) {
        TDS.getInstance().vars.put(key, value);
    }

    @Override
    public String toString() {
        return this.vars.toString();
    }
}
