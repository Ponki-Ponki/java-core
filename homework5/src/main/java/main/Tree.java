package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tree {

    public static void main(String[] args) throws IOException {
        File root = new File(".");
        File rootBackup = new File("./backup");
        print(root, "", true);
        backup(root,rootBackup);   //создание бэкапа
        deleteFile(rootBackup); // удаление бэкапа
    }

    /**
     * TODO: Доработан
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;


        int subDirTotal = 0;
        int subFileTotal = 0;
        for (File item : files) {
            if (item.isDirectory())
                subDirTotal++;
            else {
                subFileTotal++;
            }
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (File value : files) {
            if (value.isDirectory()) {
                subDirCounter++;
                print(value, indent, subDirCounter == subDirTotal);
            } else {
                subFileCounter++;
                print(value, indent, subFileCounter == subFileTotal);
            }
        }

    }

    /**
     * Создание бэкапа в корне, с условием, что такого католога нет
     * @param source путь что сохранять
     * @param dest путь куда сохранять
     * @throws IOException ловим ошибки из копирования файлов
     */
    public static void backup(File source,File dest) throws IOException {
        File[] listFiles = source.listFiles();
        if (listFiles == null) {
            System.out.println("File & directory is not found!");
            return;
        }
        if (dest.mkdir()){
            for (File f : listFiles) {
                File destNew = new File(dest.getPath()+ "\\"+ f.getName());
                if (f.isDirectory()) {
                    backup(f,destNew);
                } else {
                    System.out.print(f.getPath() + " : COPY_____________ ");
                    copyFile(f,destNew);
                    System.out.println(destNew + "  : OK!");
                }
            }
        }
    }

    /**
     * Копирование файла через поток
     * @param source путь к файлу
     * @param dest путь куда копировать
     * @throws IOException ловим ошибку если файл не найден
     */
    private static void copyFile(File source, File dest) throws IOException {
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     * Удаление папки
     * @param source путь к папке
     */
    private static void deleteFile(File source){
        File[] listFiles = source.listFiles();
        if (listFiles == null) {
            return;
        }
        if (listFiles.length == 0)
            System.out.println(source.getPath() + " | Delete catalog: "+ (source.delete()? "OK" : "NO"));
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                deleteFile(listFiles[i]);
            } else {
                System.out.println(listFiles[i].getPath() + " | Delete file: " + (listFiles[i].delete()? "OK" : "NO"));
            }
            if (i == listFiles.length-1)
                System.out.println(source.getPath() + " | Delete catalog: "+ (source.delete()? "OK" : "NO"));
        }
    }

}
