import java.awt.*;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Class to test the HuffmanTree class
 */
public class HuffmanTree {

    private PriorityQueue<BinaryTree<LabelFreq>> pq = null;
    private Comparator<BinaryTree<LabelFreq>> comparator = new PqComparator();
    private BinaryTree<LabelFreq> root = null;

    public class PqComparator implements Comparator {
        public int compare(Object o, Object t1) {
            BinaryTree<LabelFreq> elem1 = (BinaryTree<LabelFreq>) o;
            BinaryTree<LabelFreq> elem2 = (BinaryTree<LabelFreq>) t1;
            return elem1.root.data.freq - elem2.root.data.freq;
        }
    }

    public HuffmanTree(Scanner scanner) {
        readFile(scanner);
        if (pq.size() == 0) {
            return;
        }

        Integer i = 0;

        while (pq.size() > 1) {
            i++;
            BinaryTree<LabelFreq> bt = pq.poll();
            BinaryTree<LabelFreq> bt2 = pq.poll();
            String label = "T" + i.toString();
            BinaryTree<LabelFreq> btRoot = new BinaryTree<LabelFreq>(new LabelFreq(label,
                    bt2.root.data.freq + bt.root.data.freq), null, null);
            BinaryTree.Node<LabelFreq> nodeBt = bt.root;
            BinaryTree.Node<LabelFreq> nodeBt2 = bt2.root;
            if (comparator.compare(bt, bt2) > 0) {
                btRoot.root.left = nodeBt2;
                btRoot.root.right = nodeBt;
            } else {
                btRoot.root.left = nodeBt;
                btRoot.root.right = nodeBt2;
            }
            pq.offer(btRoot);
        }

        // last element is root
        root = pq.poll();
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void print() {
        if (root == null) {
            System.out.println("Huffman tree empty.");
            return;
        }
        System.out.println(root.toString());
    }

    private void readFile(Scanner scanner) {
        resetPriorityQueue();
        while (scanner.hasNextLine()) {
            String label = scanner.next();
            if (label.equalsIgnoreCase("exit")) {
                return;
            }
            int freq = (int) scanner.nextInt();
            pq.offer(new BinaryTree<LabelFreq>(new LabelFreq(label, freq), null, null));
        }
    }

    private void resetPriorityQueue() {
        pq = new PriorityQueue<BinaryTree<LabelFreq>>(50, comparator);
    }

    public static void main(String[] args) throws Exception {
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

