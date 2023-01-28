import java.util.InputMismatchException;
import java.util.Scanner;


class Day{
    private String work;

    public void Set(String work){
        this.work = work;
    }

    public String Show(){
        if(work == null){
            return "없습니다";
        }
        else {
            return work + "입니다";
        }
    }
}

class MonthSchedule{
    private int days;

    public MonthSchedule(){}
    public MonthSchedule(int days){
        this.days = days;
    }

    public void run(){
        Day d[] = new Day[days];
        for(int i=0;i<d.length;i++){
            d[i] = new Day();
        }

        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        
        while(flag){

            for(int i=0;i<1;i++){   //잘못 입력에 대해 예외 처리를 하고 다시 입력하려면 이런식으로 구현)
                try{        
                    System.out.print("작업 (입력 : 1, 보기 : 2, 종료 : 3)");
                    int menu = scan.nextInt();
                    if(menu == 1){
                        System.out.print("날짜 : ");
                        int day = scan.nextInt();
                        scan.nextLine();
                        System.out.print("할일 : ");
                        String work = scan.nextLine();
                        input(d[day], work);

                    }
                    else if(menu == 2){
                        System.out.print("날짜 : ");
                        int day = scan.nextInt();
                        view(d[day], day);
                    }
                    else if(menu == 3){
                        flag = finsih();    //while문 외부에 선언된 flag를 내부에서 설정할 수 있음
                    }
                    else{
                        System.out.println("잘못된 입력");
                    }
        
                }catch(InputMismatchException e){
                    System.out.println("잘못된 입력");
                    scan.nextLine();        //잘못된 입력이 들어있는 버퍼 비워줘야 함(무한 루프 걸림)
                    i--;
                }
            }
        }

        scan.close();


    }

    public void input(Day d,String work){
        d.Set(work);
    }

    public boolean finsih(){
        System.out.println("종료");
        return false;
    }

    public void view(Day d, int day){
        System.out.println(day + "일에 할 일은 " + d.Show());
    }
}

public class App {
    public static void main(String [] args){
        
        System.out.println("이번달 스케줄 관리 프로그램");
        MonthSchedule april = new MonthSchedule(30);
        april.run();

    }
}