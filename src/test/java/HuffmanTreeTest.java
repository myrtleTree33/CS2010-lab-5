/**
 * Created by joel on 2/18/15.
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffmanTreeTest {
    
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        HuffmanTree tree = null;
        try {
            tree = new HuffmanTree(new Scanner(new File("sample1.txt")));
            tree.print();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//    fail("Not yet implemented");
    }
    
    @Test
    public void testHuffmanTree() {
        String[] filenames = {"sample1.txt", "sample2.txt","sample3.txt", "sample4.txt", "sample5.txt"};
        HuffmanTree tree = null;
        try {
            for (String filename : filenames) {
                System.out.println("=============================");
                System.out.println("Running test=" + filename);
                System.out.println("=============================");
                tree = new HuffmanTree(new Scanner(new File(filename)));
                tree.print();
                System.out.println("===================");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
