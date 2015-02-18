import java.util.Comparator;

public class LabelFreq implements Comparator, Comparable {
  // an object describing the vertex label and its frequency
  public String label;
  public int freq;
  public LabelFreq() {}
  public LabelFreq(String l, int f) {
    label = l;
    freq = f;
  }
  public String toString() {
    return new String("("+label+","+freq+")");
  }

    public int compare(Object t2, Object t1) {
        return ((LabelFreq) t2).freq - ((LabelFreq) t1).freq;
    }

    public int compareTo(Object o) {
        return this.freq - ((LabelFreq) o).freq;
    }
}