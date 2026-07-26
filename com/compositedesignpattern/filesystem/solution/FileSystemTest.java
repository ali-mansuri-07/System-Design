package com.compositedesignpattern.filesystem.solution;

public class FileSystemTest {

    static FileSystem fs;
    static Directory root, src, docs, models;
    static File mainJava, utilsJava, userJava, readme, notes;

    static void setup() {
        fs     = new FileSystem();
        root   = fs.getRoot();
        src    = new Directory("src");
        docs   = new Directory("docs");
        models = new Directory("models");

        mainJava  = new File("Main.java",  5.0);
        utilsJava = new File("Utils.java", 3.0);
        userJava  = new File("User.java",  2.0);
        readme    = new File("README.md",  1.0);
        notes     = new File("notes.txt",  0.5);

        models.add(userJava);
        src.add(mainJava); src.add(utilsJava); src.add(models);
        docs.add(readme);  docs.add(notes);
        root.add(src);     root.add(docs);
    }

    // ── Test 1: File size returns own size ────────────────────
    static void testFileSize() {
        System.out.println("\n== TEST 1: File size ==");
        setup();
        assert mainJava.getSize() == 5.0 : "FAIL";
        assert notes.getSize()    == 0.5 : "FAIL";
        System.out.println("PASS — file.getSize() returns own size");
    }

    // ── Test 2: Directory size sums all children ──────────────
    static void testDirectorySize() {
        System.out.println("\n== TEST 2: Directory size ==");
        setup();
        assert models.getSize() == 2.0  : "FAIL — models";
        assert src.getSize()    == 10.0 : "FAIL — src";
        assert docs.getSize()   == 1.5  : "FAIL — docs";
        assert root.getSize()   == 11.5 : "FAIL — root";
        System.out.println("PASS — directory.getSize() sums children recursively");
    }

    // ── Test 3: Nested directory size ─────────────────────────
    static void testNestedSize() {
        System.out.println("\n== TEST 3: Nested size ==");
        setup();
        // src = Main(5) + Utils(3) + models(User=2) = 10
        assert src.getSize() == 10.0 : "FAIL";
        System.out.println("PASS — nested directories sum correctly");
    }

    // ── Test 4: Add file and verify size updates ──────────────
    static void testAddFile() {
        System.out.println("\n== TEST 4: Dynamic add ==");
        setup();
        double before = root.getSize(); // 11.5
        File newFile = new File("Extra.java", 4.0);
        src.add(newFile);
        assert root.getSize() == before + 4.0 : "FAIL";
        System.out.println("PASS — size updates after add: " + root.getSize() + " KB");
    }

    // ── Test 5: Remove file and verify size updates ───────────
    static void testRemoveFile() {
        System.out.println("\n== TEST 5: Dynamic remove ==");
        setup();
        double before = root.getSize(); // 11.5
        src.remove(utilsJava);          // remove 3.0 KB
        assert root.getSize() == before - 3.0 : "FAIL";
        System.out.println("PASS — size updates after remove: " + root.getSize() + " KB");
    }

    // ── Test 6: Search finds file deep in tree ────────────────
    static void testSearch() {
        System.out.println("\n== TEST 6: Search ==");
        setup();
        FileSystemComponent found = fs.search("User.java");
        assert found != null               : "FAIL — not found";
        assert found.getName().equals("User.java") : "FAIL — wrong name";
        assert found.getSize() == 2.0      : "FAIL — wrong size";
        System.out.println("PASS — found: " + found.getName());
    }

    // ── Test 7: Search returns null for missing ───────────────
    static void testSearchMissing() {
        System.out.println("\n== TEST 7: Search missing ==");
        setup();
        FileSystemComponent result = fs.search("Ghost.java");
        assert result == null : "FAIL";
        System.out.println("PASS — missing file returns null");
    }

    // ── Test 8: Uniform treatment — same call on file and dir ─
    static void testUniformTreatment() {
        System.out.println("\n== TEST 8: Uniform treatment ==");
        setup();
        // This is the CORE of Composite pattern
        FileSystemComponent[] components = {mainJava, src, docs};
        double[] expectedSizes = {5.0, 10.0, 1.5};

        for (int i = 0; i < components.length; i++) {
            assert components[i].getSize() == expectedSizes[i]
                : "FAIL at " + components[i].getName();
        }
        System.out.println("PASS — same getSize() call works on File and Directory");
    }

    // ── Test 9: File cannot add children ─────────────────────
    static void testLeafCannotAddChildren() {
        System.out.println("\n== TEST 9: Leaf add throws exception ==");
        setup();
        try {
            mainJava.add(notes); // should throw
            System.out.println("FAIL — should have thrown");
        } catch (UnsupportedOperationException e) {
            System.out.println("PASS — " + e.getMessage());
        }
    }

    // ── Test 10: Count files and directories ──────────────────
    static void testCount() {
        System.out.println("\n== TEST 10: Count ==");
        setup();
        assert fs.countFiles(root)       == 5 : "FAIL files";
        assert fs.countDirectories(root) == 4 : "FAIL dirs";
        System.out.println("PASS — files: " + fs.countFiles(root) +
                           ", dirs: " + fs.countDirectories(root));
    }

    // ── Test 11: Empty directory has size 0 ──────────────────
    static void testEmptyDirectory() {
        System.out.println("\n== TEST 11: Empty directory ==");
        Directory empty = new Directory("empty");
        assert empty.getSize() == 0.0 : "FAIL";
        System.out.println("PASS — empty directory size = 0.0");
    }

    // ── Run all ───────────────────────────────────────────────
    public static void main(String[] args) {
        testFileSize();
        testDirectorySize();
        testNestedSize();
        testAddFile();
        testRemoveFile();
        testSearch();
        testSearchMissing();
        testUniformTreatment();
        testLeafCannotAddChildren();
        testCount();
        testEmptyDirectory();
        System.out.println("\n====== All tests passed ======");
    }
}