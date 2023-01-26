import java.util.Scanner;

//update test

class Seat {
    private String name;

    public Seat() {
        this.name = "_ _ _";
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return this.name;
    }

}


public class App2{
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.print("입력 : ");
        String x =scan.nextLine();

        System.out.print("입력 1 : ");
        int y = scan.nextInt();

        System.out.println(x + " " + y);

        Seat yy = new Seat();
        yy.SetName(x);

        System.out.println(yy.GetName());
        scan.close();
    }
}