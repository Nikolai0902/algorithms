package patterns.сreational.singelton;

public final class Log {

    private static Log instance = null;

    private String[] messages = new String[1000];
    private int index = 0;

    private Log() {
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public void save() {
        //TODO Сохраняем записи из массива messages в файл.
    }

    public static void main(String[] args) {
        Log log = Log.getInstance();
        log.add("add new Item");
        log.save();
    }
}
