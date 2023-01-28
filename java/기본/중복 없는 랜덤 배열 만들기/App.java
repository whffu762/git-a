




//실행시키려면 src 파일 아래에 가져다놓고 실행시켜야 함 여기다두면 class 못 찾음


//아니면 1 ~ 100까지 배열 만들고 shuffle 해도 됨....


import java.util.Scanner;

public class App {

//flag 이용
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Input : ");
        int target = scan.nextInt();
        int ary[] = new int [target];

        boolean flag;

        for (int i=0;i<target;i++){
            while(true){
                ary[i] = (int)(Math.random()* 100 + 1);
                flag = false;

                for(int j=0;j<i;j++){
                    if(ary[i]==ary[j]){
                        flag = true;
                        break;
                    }
                    else{
                        flag = false;
                    }

                }
                if(!flag){
                    break;
                }
            }
            System.out.print(ary[i] + ", ");
        }

        scan.close();
    }
/*
//재귀함수 이용
    public static void check(int[] ary, int i){
        
        for (int j=0;j<i;j++){
            if(ary[j] == ary[i]){
                int tmp = (int)(Math.random()*100 + 1);
                ary[i] = tmp;
                check(ary, i);
            }
        }

    }
 
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Input : ");
        int target = scan.nextInt();
        int ary[] = new int [target];

        int tmp;

        for (int i=0;i<target;i++){
            tmp = (int)(Math.random()*100+1);
            ary[i] = tmp;
            check(ary, i);

        }

        scan.close();
        
        for(int x : ary){
            System.out.print(x + ", ");
        }
        
    
    }*/
}