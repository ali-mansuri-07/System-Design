package com.compositedesignpattern.filesystem.solution;

// Helper that manages the root and provides file system operations
public class FileSystem {
    private Directory root;

    public FileSystem() {
        root = new Directory("root");
    }

    public Directory getRoot() { return root; }

    // Display full tree from root
    public void displayTree() {
        System.out.println("\n=== File System Tree ===");
        root.display("");
        System.out.println("========================\n");
    }

    // Get total size of entire file system
    public double getTotalSize() {
        return root.getSize();
    }

    // Search entire file system for a name
    public FileSystemComponent search(String name) {
        return root.search(name);
    }

    // Count all files recursively
    public int countFiles(FileSystemComponent component) {
        if (component instanceof File) return 1;
        int count = 0;
        Directory dir = (Directory) component;
        for (FileSystemComponent child : dir.getChildren()) {
            count += countFiles(child);
        }
        return count;
    }

    // Count all directories recursively
    public int countDirectories(FileSystemComponent component) {
        if (component instanceof File) return 0;
        int count = 1; // count this directory
        Directory dir = (Directory) component;
        for (FileSystemComponent child : dir.getChildren()) {
            count += countDirectories(child);
        }
        return count;
    }
}