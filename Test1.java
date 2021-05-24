import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test1 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n*3];
        for(int i = 0; i < n*3; i++){
            array[i] = s.nextInt();
        }
        Arrays.sort(array);
        int ret = 0;
        for(int i = n; i < array.length-n; i++){
            ret += array[i];
        }
        System.out.println(ret);
    }

    public void removeSte(){
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
