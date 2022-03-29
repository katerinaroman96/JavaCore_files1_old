package com.iostream.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static StringBuilder dirCreation(File dir, StringBuilder sb) {
        Date date = new Date();
        if (dir.mkdir()) {
            sb.append("Каталог \"")
                    .append(dir.getName())
                    .append("\" создан (")
                    .append(date)
                    .append(")");
        } else {
            sb.append("Каталог \"")
                    .append(dir.getName())
                    .append("\" не был создан ");
        }
        sb.append("\n");
        return sb;
    }

    public static StringBuilder fileCreation(File file, StringBuilder sb) {
        Date date = new Date();
        try {
              if(file.createNewFile()) {
                  sb.append("Файл \"")
                          .append(file.getName())
                          .append("\" создан ")
                          .append(date)
                          .append(")");
              } else {
                  sb.append("Файл \"")
                          .append(file.getName())
                          .append("\" не был создан ");
              }
        } catch (IOException exception) {
            sb.append(exception.getMessage());
        }
        sb.append("\n");
        return sb;
    }

    public static void main(String[] args) {
        File src = new File("C://Games//src");
        File res = new File("C://Games//res");
        File saveGames = new File("C://Games//savegames");
        File temp = new File("C://Games//temp");
        File main = new File("C://Games//src//main");
        File test = new File("C://Games//src//test");
        File mainFile = new File(main, "Main.java");
        File utilsFile = new File(main, "Utils.java");
        File drawables = new File("C://Games//res//drawables");
        File vectors = new File("C://Games//res//vectors");
        File icons = new File("C://Games//res//icons");
        File tempFile = new File(temp, "temp.txt");
        StringBuilder sb = new StringBuilder();
        dirCreation(src, sb);
        dirCreation(res, sb);
        dirCreation(saveGames, sb);
        dirCreation(temp, sb);
        dirCreation(main, sb);
        dirCreation(test, sb);
        dirCreation(drawables, sb);
        dirCreation(vectors, sb);
        dirCreation(icons, sb);
        fileCreation(mainFile, sb);
        fileCreation(utilsFile, sb);
        fileCreation(tempFile, sb);

        String log = sb.toString();
        try {
            FileWriter writer = new FileWriter(tempFile, false);
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
