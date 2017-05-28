package algorithms.easysort;

import algorithms.utils.Array;

/**
 * Created by lukCy on 2017/3/15.
 */
public class SelectSort {
    Array a;

    public SelectSort(int n){
        a = new Array(n);
    }

    public void Add(long value){
        a.Additems(value);
    }

    public void display(){
        a.display();
    }
    //思考为什么把out的循环倒过来就不行？3142,3124,2134,1234
    public void selectSort(){
        int min,out,j;
//        for(int out = a.getNlength()-1; out >= 0  ; out--){
        for( out = 0 ; out < a.getNlength() - 1; out++){
                min = out;
                for ( j = out+1 ; j< a.getNlength() ; j++ ) {
                    if (a.getA()[j] < a.getA()[min])
                        min = j;
                    a.swap(out , min);
                }


        }
    }

    public static void main(String[] args) {
        SelectSort b = new SelectSort(4);
        b.Add(3);b.Add(1);b.Add(4);b.Add(2);
        b.selectSort();
        b.display();
    }
}
