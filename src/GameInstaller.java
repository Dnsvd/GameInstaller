import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Bless\\Desktop\\Games";
        StringBuilder log = new StringBuilder();

        String[] dirs = {
                basePath + "/src", basePath + "/res", basePath + "/savegames", basePath + "/temp",
                basePath + "/src/main", basePath + "/src/test",
                basePath + "/res/drawables", basePath + "/res/vectors", basePath + "/res/icons"
        };

        for (String dir : dirs) {
            File directory = new File(dir);
            if (directory.mkdir()) {
                log.append("Каталог создан: ").append(dir).append("\n");
            } else {
                log.append("Не удалось создать каталог: ").append(dir).append("\n");
            }
        }

        String[] files = {
                basePath + "/src/main/Main.java", basePath + "/src/main/Utils.java", basePath + "/temp/temp.txt"
        };

        for (String file : files) {
            try {
                File newFile = new File(file);
                if (newFile.createNewFile()) {
                    log.append("Файл создан: ").append(file).append("\n");
                } else {
                    log.append("Не удалось создать файл: ").append(file).append("\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла: ").append(file).append(" - ").append(e.getMessage()).append("\n");
            }
        }

        try (FileWriter writer = new FileWriter(basePath + "/temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка записи лога: " + e.getMessage());
        }
    }
}
