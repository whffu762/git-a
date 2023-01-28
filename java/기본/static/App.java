import java.util.InputMismatchException;
import java.util.Scanner;

class ArrayUtil{

    public static int x;
    public int y;

    public static int [] concat(int[] a, int [] b){
        int size = a.length + b.length ;
        int [] ary = new int [size];

        for(int i=0;i<size;i++){
            if(i<a.length){
                ary[i] = a[i];
            }
            else{
                ary[i] = b[i - a.length];
            }
        }

        return ary;

    }

    public static void print(int [] a){

        System.out.print("{ ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        
        System.out.print("}");

    }

    public static int sum(int x, int y){
        return x + y;
    }
}

class ArrayTest{
    public void Print(int [] ary1){
        for(int i=0;i<ary1.length;i++){
            System.out.println(ary1[i]);
        }
    }
}
public class App {
    public static void main(String[] args) {

        int [] ary1 = {1, 5, 7, 9};
        int [] ary2 = {3 ,6, -1, 100, 77};
        int [] ary3 = ArrayUtil.concat(ary1, ary2); //ArrayUtil 객체를 만들지 않고도 메소드를 사용할 수 있음
        //파라미터가 배열이라 static 메소드여야 하는게 아님 static 메소드 아닐 땐 객체 만들면 메소드 이용할 수 있음

        ArrayUtil.print(ary3);

        ArrayTest test = new ArrayTest();
        test.Print(ary1);   //이런 식으로 static이 아닌 메소드는 객체를 생성하고 사용하면 됨

//        int result = ArrayUtil.sum(ArrayUtil.x,ArrayUtil.y); 당연한 소리지만 static이 아닌 멤버변수에는 접근할 수 없다(접근할 방법이 없음)
            //static 멤버 변수의 경우 class 명으로도 접근 가능하니까 접근할 수 있음
//        System.out.println(result);
    }
}