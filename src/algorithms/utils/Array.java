package algorithms.utils;

/**
 * Created by lukCy on 2017/3/15.
 */
public class Array {
    private long [] a;
    private int nlength;

    public long[] getA() {
        return a;
    }

    public int getNlength() {
        return nlength;
    }

    public Array(int max){
        a = new long[max] ;
        nlength = 0;
    }
    //add a items in an array.
    public void Additems(long value){
        a[nlength] = value ;
        nlength++;
    }
    //display an array
    public void display(){
        for (int i = 0 ; i < nlength ; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n");
    }

    public void swap(int m,int n){
        long temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }



}
