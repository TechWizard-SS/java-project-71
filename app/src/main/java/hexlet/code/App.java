package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

// Аннотация @Command описывает нашу команду
@Command(name = "gendiff", // Имя команды, как она будет вызываться
        mixinStandardHelpOptions = true, // Волшебная опция, которая автоматически добавляет -h и -V
        version = "1.0", // Версия вашего приложения
        description = "Compares two configuration files and shows a difference.") // Описание
public class App implements Callable<Integer> { // Реализуем интерфейс Callable

    // Эти поля будут автоматически заполнены picocli на основе аргументов командной строки
    @Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private String filePath2;

    // Опция --format (пока не используется, но будет нужна позже)
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

//    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.")
//    private String help;
//
//    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
//    private String version;

    // Этот метод содержит основную логику приложения.
    // Он будет вызван picocli после того, как аргументы будут распарсены.
    @Override
    public Integer call() throws Exception {
        // Пока просто вызываем метод Differ.generate и выводим результат
        String diff = Differ.generate(filePath1, filePath2);
        System.out.println(diff);
        return 0; // Возвращаем 0 в случае успеха (стандартная практика для CLI)
    }

    // Точка входа в приложение
    public static void main(String... args) {
        // Вся магия происходит здесь:
        // Создаём объект команды, парсим аргументы и либо вызываем call(),
        // либо показываем справку/версию, если были переданы флаги -h или -V.
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode); // Завершаем программу с кодом, который вернул execute
    }
}
