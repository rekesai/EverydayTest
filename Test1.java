import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test1 {


    public static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            int tmp = array[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n*3];
        for(int i = 0; i < n*3; i++){
            array[i] = s.nextInt();
        }
        Arrays.sort(array);
        int ret = 0;
        for(int i = n; i < array.length; i+=2){
            ret += array[i];
        }
        System.out.println(ret);
    }


    public void removeStr(){
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str2.length(); i++){
            set.add(str2.charAt(i));
        }
        for(int i = 0; i < str1.length(); i++){
            if(!set.contains(str1.charAt(i))){
                System.out.print(str1.charAt(i));
            }
        }
    }
}
