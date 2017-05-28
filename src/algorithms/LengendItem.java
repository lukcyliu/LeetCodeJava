package algorithms;

import java.util.Scanner;

/**
 * Created by lukCy on 2017/3/31.
 */
public class  LengendItem {

    static int P;
    static int Q;
    static int N;

    static double result = 0;

    /**
     *
     * @param num   当前获得宝物个数，初始化为0
     * @param arrayProb 保存每次路径参数
     * @param prob    当前路径成功概率，初始化为0
     * @param pathLen  当前路径长度，初始化为0
     * @param p     初始成功概率，初始化为P
     */
    public static void getPath(int num,int[] arrayProb ,int prob, int pathLen, int p){
        if (num < N)
        {
            //首先递归左子树，也就是成功路径子树,成功只有三种情况
            if (prob >= 100){
                arrayProb[pathLen] = 100;
                getPath(num+1, arrayProb, 0, pathLen+1, (int)(p/Math.pow(2,num+1)));
            }else if(prob > 0){
                arrayProb[pathLen] = prob;
                getPath(num+1,arrayProb,0, pathLen+1, (int)(p/Math.pow(2,num+1)));
            } else if (p > 0){
                arrayProb[pathLen] = p;
                getPath(num+1, arrayProb, 0, pathLen+1, (int)(p/Math.pow(2,num+1)));
            }

            //再遍历同层右子树，也就是失败路径概率。prob<100，才有失败可能。
            if (prob < 100 && p < 100) {
                int tmp;
                if(prob == 0){//只有第一次或者成功后prob才会为0
                    tmp = 100 - p;
                    prob = p;
                }else {
                    tmp = 100 - prob;
                }
                arrayProb[pathLen] = tmp;
                getPath(num, arrayProb, prob + Q, pathLen + 1,p);
            }
        } else{
            double tmp = 1;
            for (int i = 0; i < pathLen; i++) {
                tmp *= 0.01 * arrayProb[i];
                System.out.printf(arrayProb[i] + " ");
            }
            System.out.println();
            tmp *= pathLen;
            result += tmp;
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] array = new int[100000];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            result = 0;
            P = scanner.nextInt();
            Q = scanner.nextInt();
            N = scanner.nextInt();
            getPath(0,array,0,0,P);
            System.out.printf("%.2f", result);
        }
    }
}
