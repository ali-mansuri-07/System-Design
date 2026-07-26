package com.compositedesignpattern.filesystem.solution;

// Composite node — holds children, delegates operations to them
import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    // Key method — recursively sums size of ALL children
    // Client doesn't care if children are files or directories
    @Override
    public double getSize() {
        double total = 0;
        for (FileSystemComponent child : children) {
            total += child.getSize(); // each child handles its own size
        }
        return total;
    }

    // Recursively prints the full tree with indentation
    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name +
                           "/  (" + getSize() + " KB)");
        for (FileSystemComponent child : children) {
            child.display(indent + "    "); // deeper indent for children
        }
    }

    // Directory-specific operations
    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
        System.out.println("Added [" + component.getName() +
                           "] to [" + name + "]");
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
        System.out.println("Removed [" + component.getName() +
                           "] from [" + name + "]");
    }

    public List<FileSystemComponent> getChildren() {
        return children;
    }

    // Search for a file by name anywhere in the tree
    public FileSystemComponent search(String targetName) {
        if (this.name.equals(targetName)) return this;
        for (FileSystemComponent child : children) {
            if (child.getName().equals(targetName)) return child;
            if (child instanceof Directory) {
                FileSystemComponent found =
                    ((Directory) child).search(targetName);
                if (found != null) return found;
            }
        }
        return null; // not found
    }
}