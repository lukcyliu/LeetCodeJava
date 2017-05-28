package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukCy on 2017/5/2.
 */
public class _241DiffrentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch== '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int l : left){
                    for (int r : right){
                        switch (ch){
                            case '+':
                                res.add(l+r);
                                break;
                            case '-':
                                res.add(l-r);
                                break;
                            case '*':
                                res.add(l*r);
                                break;
                        }
                    }
                }

            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }

    public static void main(String[] args) {
        String a = "2*3-4*5";

    }
}
