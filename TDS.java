
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
        // return (this.vars.size() > 0) ? this.vars.get(entry).toString() : "";
    }

    public static void put(String key, Type value) {
        TDS.getInstance().vars.put(key, value);
    }

    public boolean containsKey(String key) {
        return this.vars.containsKey(key);
    }

    public void flush() {
        this.vars = new HashMap<>();
    }

    @Override
    public String toString() {
        return this.vars.toString();
    }
}
