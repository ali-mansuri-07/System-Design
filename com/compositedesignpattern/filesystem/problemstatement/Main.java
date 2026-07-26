package com.compositedesignpattern.filesystem.problemstatement;

import java.util.ArrayList;
import java.util.List;

// BAD DESIGN - File and Folder are treated differently
class FileItem {
    String name;
    int size;

    public FileItem(String name, int size) {
        this.name = name;
        this.size = size;
    }
}

class Folder {
    String name;
    List<FileItem> files;
    List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    // Caller must handle files and folders separately
    int getTotalSize() {
        int total = 0;

        for (FileItem file : files) {
            total += file.size;
        }

        for (Folder folder : subFolders) {
            total += folder.getTotalSize();
        }

        return total;
    }
}

public class Main {

    // Client code is messy because it knows about both File and Folder
    static void printAll(Folder folder) {

        for (FileItem file : folder.files) {
            System.out.println(file.name);
        }

        for (Folder subFolder : folder.subFolders) {
            printAll(subFolder);
        }
    }

    public static void main(String[] args) {

        Folder root = new Folder("Root");

        root.files.add(new FileItem("File1.txt", 100));
        root.files.add(new FileItem("File2.txt", 200));

        Folder subFolder = new Folder("SubFolder");
        subFolder.files.add(new FileItem("File3.txt", 300));

        root.subFolders.add(subFolder);

        System.out.println("Files:");
        printAll(root);

        System.out.println("\nTotal Size: " + root.getTotalSize() + " KB");
    }
}