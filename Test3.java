import java.util.*;

class Person{
    public String name = "zxc";
    private String name2 = "asd";
    public Person(){

    }
    public void func(){

    }
}
class ad{
    public void funad(){

    }
}
class Child extends Person{
    public String grade;
    public void func(){
        super.func();
        new ad().funad();
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        int n = 0;
        //遍历map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > array.length/2){
                n = entry.getKey();
            }
        }
        return n;
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        String str = s.nextLine();
        int i = 0;
        while(i < str.length()){
            ArrayList<Character> charList = new ArrayList<>();
            while(i < str.length() && str.charAt(i) >= 48 && str.charAt(i) <= 57){
                charList.add(str.charAt(i));
                i++;
            }
            list.add(charList);
            i++;
        }
        int max = 0;
        int index = 0;
        for(int j = 0; j < list.size(); j++){
            int n = list.get(j).size();
            if(n > max){
                max = n;
                index = j;
            }
        }
        for(int j = 0; j < list.get(index).size(); j++){
            System.out.print(list.get(index).get(j));
        }
    }



    public static void main2(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(1);
        int a = Collections.max(list);
        System.out.println(a);
        list.clear();
        list.get(2);
    }
}


public class Test3 {

}
