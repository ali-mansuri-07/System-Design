package com.compositedesignpattern.filesystem.solution;

public class Main {
    public static void main(String[] args) {

        // ── Build the file system ────────────────────────────

        FileSystem fs = new FileSystem();
        Directory root = fs.getRoot();

        // Create files
        File mainJava  = new File("Main.java",   5.0);
        File utilsJava = new File("Utils.java",  3.0);
        File userJava  = new File("User.java",   2.0);
        File readme    = new File("README.md",   1.0);
        File notes     = new File("notes.txt",   0.5);

        // Create directories
        Directory src    = new Directory("src");
        Directory docs   = new Directory("docs");
        Directory models = new Directory("models");

        // Assemble the tree
        models.add(userJava);         // models/ ← User.java

        src.add(mainJava);            // src/ ← Main.java
        src.add(utilsJava);           // src/ ← Utils.java
        src.add(models);              // src/ ← models/

        docs.add(readme);             // docs/ ← README.md
        docs.add(notes);              // docs/ ← notes.txt

        root.add(src);                // root/ ← src/
        root.add(docs);               // root/ ← docs/

        // ── Display the tree ─────────────────────────────────

        fs.displayTree();
        // === File System Tree ===
        // 📁 root/  (11.5 KB)
        //     📁 src/  (10.0 KB)
        //         📄 Main.java  (5.0 KB)
        //         📄 Utils.java  (3.0 KB)
        //         📁 models/  (2.0 KB)
        //             📄 User.java  (2.0 KB)
        //     📁 docs/  (1.5 KB)
        //         📄 README.md  (1.0 KB)
        //         📄 notes.txt  (0.5 KB)
        // ========================

        // ── Get sizes — works uniformly on any node ──────────

        System.out.println("Total FS size     : " + fs.getTotalSize() + " KB");
        // 11.5 KB

        System.out.println("src/ size         : " + src.getSize() + " KB");
        // 10.0 KB

        System.out.println("models/ size      : " + models.getSize() + " KB");
        // 2.0 KB

        System.out.println("Main.java size    : " + mainJava.getSize() + " KB");
        // 5.0 KB  ← same method called on a File (leaf)

        // ── Search ───────────────────────────────────────────

        System.out.println("\n--- Search ---");
        FileSystemComponent found = fs.search("User.java");
        if (found != null)
            System.out.println("Found: " + found.getName() +
                               " (" + found.getSize() + " KB)");
        // Found: User.java (2.0 KB)

        FileSystemComponent notFound = fs.search("Ghost.java");
        System.out.println("Ghost.java found? " + (notFound != null));
        // Ghost.java found? false

        // ── Count files and directories ──────────────────────

        System.out.println("\n--- Stats ---");
        System.out.println("Total files       : " + fs.countFiles(root));
        // 5
        System.out.println("Total directories : " + fs.countDirectories(root));
        // 4  (root, src, models, docs)

        // ── Add and remove dynamically ───────────────────────

        System.out.println("\n--- Dynamic operations ---");

        File configFile = new File("config.json", 0.2);
        root.add(configFile);
        // Added [config.json] to [root]

        System.out.println("New total size    : " + fs.getTotalSize() + " KB");
        // 11.7 KB

        root.remove(configFile);
        // Removed [config.json] from [root]

        System.out.println("After remove      : " + fs.getTotalSize() + " KB");
        // 11.5 KB

        // ── Key demonstration — uniform treatment ────────────

        System.out.println("\n--- Uniform treatment ---");

        // Array of mixed Files and Directories
        FileSystemComponent[] components = {mainJava, src, docs, userJava};

        // Same code works on ALL — client doesn't check type!
        for (FileSystemComponent c : components) {
            System.out.println(c.getName() +
                               " → size: " + c.getSize() + " KB");
        }
        // Main.java → size: 5.0 KB
        // src       → size: 10.0 KB
        // docs      → size: 1.5 KB
        // User.java → size: 2.0 KB
    }
}