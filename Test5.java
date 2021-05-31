
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Test5 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        boolean flag = false;
        for(int i = 0; i < n; i++){
            array[i] = s.nextInt();
            if(array[i] > 0){
                flag = true;
            }
        }
        //如果数组中有大于零的数
        if(flag){
            int max = array[0];
            int sum = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] > 0){
                    sum += array[i];
                }
                else{
                    if(sum > max){
                        max = sum;
                    }
                    sum = 0;
                }
            }
            System.out.println(max);
        }
        //如果数组中没有大于0的数字，则将数组排序，取最后一个数字即可
        else{
            Arrays.sort(array);
            System.out.println(array[array.length-1]);
        }
    }


    /*
    * 输入两个字符串，要将第二个插入到第一个之中，输出有多少中插入方法
    * */
    public void tenetNumber(){
        Scanner s = new Scanner(System.in);
        StringBuilder strA = new StringBuilder(s.nextLine());
        String strB = s.nextLine();
        int count = 0;
        //循环访问StringBuilder，用方法insert可以将另外的字符串插入到你给的下标之前
        //但是这样会改变原有的字符串，所以要新定义一个StringBuilder
        for(int i = 0; i < strA.length(); i++){
            StringBuilder str = new StringBuilder(strA);
            if(tenet(str.insert(i, strB))){
                count++;
            }
        }
        if(tenet(strA.append(strB))){
            count++;
        }
        System.out.println(count);
    }
    //判断是否回文结构
    public boolean tenet(StringBuilder str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
