package chimbeev.test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Path to root directory: ");
        String rootPath = reader.readLine();
        reader.close();
        PathManager pathManager = new PathManager(Paths.get(rootPath));
        List<Path> fileList = pathManager.getFileList();
        // Файл с результатом создается в корневой папке
        BufferedWriter writer = new BufferedWriter(new FileWriter(rootPath + "\\result.txt"));
        for (int i = 0; i < fileList.size() ; i++) {
            reader = new BufferedReader(new FileReader(rootPath + "\\" + fileList.get(i)));
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
            writer.newLine();
            reader.close();
        }
        writer.close();
    }
}
