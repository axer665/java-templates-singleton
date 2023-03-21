import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;

    public void log(String msg) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        System.out.println("[" + formatForDateNow.format(dateNow) + " " + num++ + "] " + msg);
    }

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

}