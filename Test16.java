import java.util.*;
public class Test16{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int n = s.nextInt();
            int count = 0;
            for(int i = 1; i <= n; i++){
                int sum = 0;
                for(int j = 1; j < i; j++){
                    if(i%j == 0){
                        sum += j;
                    }
                }
                if(sum == i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}