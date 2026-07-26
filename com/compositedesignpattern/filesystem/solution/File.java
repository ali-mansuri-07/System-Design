package com.compositedesignpattern.filesystem.solution;

// Leaf node — has no children, cannot add/remove
public class File implements FileSystemComponent {
    private String name;
    private double size; // in KB

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getSize() { return size; } // leaf: just return own size

    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 " + name + "  (" + size + " KB)");
    }

    // Leaf cannot have children — meaningful error messages
    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException(
            "Cannot add to a file: " + name);
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException(
            "Cannot remove from a file: " + name);
    }
}
