import java.util.InputMismatchException;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;
        for(int i=0;i<1;i++){
            try{
                System.out.print("input x : ");
                x = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("wrong input");
                scan.nextLine();
                i--;
            }
        }
        for(int i=0;i<1;i++){    
            try{ 
                System.out.print("input y : ");
                y = scan.nextInt();

            }catch(InputMismatchException e){
                System.out.println("wrong input");
                scan.nextLine();    //버퍼를 비워줘야 다음 입력이 가능
                i--;                //예외처리가 되면 다시 입력이 되게끔
            }
        }

        System.out.println(x*y);

        scan.close();
    }
}