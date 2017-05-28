package algorithms.easysort;

import algorithms.utils.Array;

/**
 * Created by lukCy on 2017/3/15.
 * demonstrates bubble sort.
 */
public class BubbleSort  {
    int bublength;
    Array a;
    public BubbleSort(int n){
        a = new Array(n);
        bublength = n;
    }

    public void Add(long value){
        a.Additems(value);
    }

    public long[] get(){
        return a.getA();
    }

    public void display(){
        a.display();
    }


    public void bubbleSort(){
        for(int out  = bublength - 1; out >= 0 ; out--) {
            for (int i = 0; i < out; i++) {
                if (a.getA()[i] < a.getA()[i + 1])
                    a.swap(i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort(4);
        b.Add(3);b.Add(4);b.Add(1);b.Add(2);
        b.bubbleSort();
        b.display();
    }
}
