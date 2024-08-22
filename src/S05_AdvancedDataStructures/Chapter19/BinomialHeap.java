package S05_AdvancedDataStructures.Chapter19;
import java.io.*;

public class BinomialHeap {
    private BinomialHeapNode Nodes;
    private int size;

    public BinomialHeap() {
        Nodes = null;
        size = 0;
    }

    public boolean isEmpty() { return Nodes == null; }

    public int getSize() { return size; }

    public void makeEmpty() {
        Nodes = null;
        size = 0;
    }

    public void insert(int value) {
        if (value > 0) {
            BinomialHeapNode temp
                    = new BinomialHeapNode(value);
            if (Nodes == null) {
                Nodes = temp;
                size = 1;
            }
            else {
                unionNodes(temp);
                size++;
            }
        }
    }

    private void merge(BinomialHeapNode binHeap) {
        BinomialHeapNode temp1 = Nodes, temp2 = binHeap;
        while ((temp1 != null) && (temp2 != null)) {
            if (temp1.degree == temp2.degree) {
                BinomialHeapNode tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            } else {
                if (temp1.degree < temp2.degree) {
                    if ((temp1.sibling == null)
                            || (temp1.sibling.degree
                            > temp2.degree)) {
                        BinomialHeapNode tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    }
                    else
                        temp1 = temp1.sibling;
                } else {
                    BinomialHeapNode tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;
                    if (tmp == Nodes)
                        Nodes = temp1;

                    else {
                    }
                }
            }
        }
        if (temp1 == null) {
            temp1 = Nodes;

            while (temp1.sibling != null) {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        }
    }

}
