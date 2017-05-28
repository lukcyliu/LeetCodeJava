package leetcode;

/**
 * Created by lukCy on 2017/4/26.
 */
public class _338CountingBits {
    public int[] countingBits(int num){
        int[] res = new int[num+1];
        for (int i=1;i<num+1;i++){
            int count = 0;
            int k = i;
            while(k>0){
                if (k%2 == 1)
                    count++;
                k /= 2;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        for (int i=0;i<num+1;i++)
            System.out.print(new _338CountingBits().countingBits(num)[i]+" ");
    }
}
