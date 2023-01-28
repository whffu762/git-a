import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 개선사항
 * 1. 뒤로가기 기능
 * 2. 동명 이인 처리.. 근데 이건 ID 같이 unique key로 해야 함 동명이인에 관해선 처리할 필요 없을 듯
 * 3. 모듈화 하나의 파일에 다 들어가 있음
 */


//좌석 클래스
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

//좌석배열로 구성된 라인 클래스
//seat으로의 접근을 line을 통해서 함
class Line {
    private Seat[] seat;

    public Line(Seat[] seat) {
        this.seat = seat;
    }

    public void SetName(int n, String name){    //line을 이용해서 seat[i] 값 변경
        this.seat[n].SetName(name);
    }

    public Seat[] GetLine() {                   
        return this.seat;
    }

    public int GetLineNUm(){                    //line을 이용해서 seat[]의 길이를 반환
        return this.seat.length;
    }

    public String GetName(int i){               //line을 이용해서 seat[i]의 값을 반환
        return seat[i].GetName();
    }

    public void Show() {                        //line을 이용해서 seat[] 전체를 출력
        for (int i = 0; i < seat.length; i++) {
            System.out.print(seat[i].GetName() + "\t");
        }
        System.out.println(" ");
    }
}

//예약 시스템
class ReserveSYS{
        //극장 전체 구조 : 각 라인은 10개의 좌석으로 구성 전체 극장은 3개의 라인으로 구성성
        /*
        seat = name
        line = seat[]
        line [] = seat[0]의 집합
         */
        public Line[] MakingTheater(){
      
        Line[] lines = new Line[3];
        for (int i = 0; i < lines.length; i++) {
            Seat[] seatAry = new Seat[11];  //seat[0]에 라인의 이름을 명시하기 위해 11개의 요소로 구성
            for (int j = 0; j < seatAry.length; j++) {
                seatAry[j] = new Seat();
            }
            lines[i] = new Line(seatAry);
            //seat[0]에 각 라인을 명시
            if(i == 0){
                lines[i].SetName(0, "S>>");
            }
            else if(i == 1){
                lines[i].SetName(0, "A>>");
            }
            else if(i == 2){
                lines[i].SetName(0, "B>>");
            }
        }
        
        return lines;
    }

    //입력된 배열에 입력된 값이 존재하는지 확인하는 함수(CheckOption의 조각)
    public boolean CheckExist(int [] ary, int input){

        boolean flag = false;

        for(int i=0;i<ary.length;i++){
            if(input == ary[i]){
                flag = true;
            }
        }

        return flag;
    }

    //유효함과 별개로 잘못된 자료형의 데이터가 들어온 경우는 try - catch 로 처리(InputMismatchException) 

    //입력된 값이 유효한 값인지 확인1 - 입력이 정수인 경우
    public boolean CheckOption(int phase, int input){   //phase를 이용해서 각 질문의 단계를 구분해서 유효한 값을 확인
        
        int [] menu = new int [4];
        for(int i=0;i<menu.length;i++){
            menu[i] = i+1;
        }

        int [] line = new int [3];
        for(int i=0;i<line.length;i++){
            line[i] = i+1;
        }
    
        int [] seat = new int [10];
        for(int i=0;i<seat.length;i++){
            seat[i] = i+1;
        }

        boolean flag;
        if(phase == 1){ //메뉴 선택
            flag = CheckExist(menu, input);
        }
        else if(phase == 2){//줄 선택
            flag = CheckExist(line ,input);
        }
        else if(phase == 3){//좌석 선택
            flag = CheckExist(seat, input);
        }
        else {
            flag = false;
        }

        return flag;
    }

    //입력된 값이 유효한 값인지 확인2(입력된 이름이 예약자인지 확인) - 입력이 문자열인 경우
    public boolean CheckOption(Line line, String input){

        boolean flag = false;

        for(int i=1;i<line.GetLineNUm();i++){
            if(input.equals(line.GetName(i))){
                flag = true;
            }
        }

        return flag;
    }

    //입력된 line[i]를 조회하는 함수
    public void PrintLine(Line[] lines, int input){
        lines[input - 1].Show();
    }

    //이미 예약된 좌석인지 확인하는 함수(예약 기능 조각)
    public boolean CheckEmpty(Line line, int input){
        String check = line.GetName(input);
        if(check.equals("_ _ _")){
            return true;
        }
        else{        
            return false;
        }
    }
    
    //선택한 자리에 예약자 성명을 입력하는 함수(예약 기능 조각)
    public void SetSeat(Line line, int seat, String name){
        line.SetName(seat, name);
    }

    //좌석을 선택하는 함수(예약 기능 조각)
    public void SelectSeat(Scanner scan, int phase, Line line){
        boolean exist;
        System.out.print("예약자 서명 입력 : ");
        String name = scan.nextLine();
        
        for(int i=0;i<1;i++){
            try{    //int외의 입력이 들어오면 예외 처리해서 다시 입력 받음
                System.out.print("좌석 번호 입력(1 ~ 10) : ");
                phase = 3;
                int seatInput = scan.nextInt();
                exist = CheckOption(phase, seatInput);  //입력이 유효 범위 내에 있는지 확인(여기 들어온 입력은 모두 int임)
                if(exist){
                    boolean empty = CheckEmpty(line, seatInput);    //입력된 좌석이 빈 좌석인지 확인
                    if(empty){
                        SetSeat(line, seatInput, name);
                    }
                    else{
                        System.out.println("이미 예약된 좌석입니다");
                        i--;    //조건이 맞지 않으면 다시 입력받기 위해
                    }
                }
                else{
                    System.out.println("없는 좌석 번호입니다");
                    i--;
                }
            }catch(InputMismatchException e){
                System.out.println("잘못된 입력(Select Seat)");
                scan.nextLine();
                i--;
            }
        }
    }

    //예약 기능 구현
    public void Reserve(Scanner scan, int phase, Line[] lines){
        boolean exist;
        for(int i=0;i<1;i++){
            try{
                System.out.print("좌석 유형 선택 S(1) A(2) B(3) : ");
                phase = 2;
                int line = scan.nextInt();
                scan.nextLine();        //nextInt() 이후에 엔터 값은 버퍼에 남아있기 때문에 다음에 문자열을 입력 받으려면 버퍼를 비워줘야 함
                exist = CheckOption(phase, line);  
                if(exist){
                    PrintLine(lines, line);
                    System.out.println("");
                    SelectSeat(scan, phase, lines[line - 1]);   //라인 이름을 제외하기 위해 line - 1
                }
                else{
                    System.out.println("없는 좌석 유형입니다");
                    i--;    
                }

            }catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다(Line)");
                scan.nextLine();
                i--;
            }
        }
    }


    //line[i]에 예약한 인원이 있는지 확인(Cancel의 조각)
    public boolean CheckReserve(Line line){

        boolean exist = false;  

        for(int i=1;i<line.GetLineNUm();i++){
            if(line.GetName(i).equals("_ _ _")){
                //System.out.println(line.GetName(i));
                continue;
            }
            else{
                return true;
            }
        }

        return exist;
    }

    //입력된 서명의 좌석 번호를 리턴(Cancel의 조각)
    public int GetSeatNum(Line line, String name){
        
        int target = 0;
        for(int i=0;i<line.GetLineNUm();i++){
            if(line.GetName(i).equals(name)){
                target = i;
                break;
            }
        }
        return target;
    }

    //입력된 성명의 좌석을 취소(Cancel의 조각)
    public void DeleteSeat(Scanner scan, Line line){
        boolean exist;

        for(int i=0;i<1;i++){
            System.out.print("취소할 예약자 서명 입력 : ");
            String name = scan.nextLine();
            exist = CheckOption(line, name);
            if(exist){
                int target = GetSeatNum(line, name);
                line.SetName(target, "_ _ _");
            }
            else{
                System.out.println("예약 명단에 없습니다");
                i--;
            }

        }
    }
    
    //Cancle 구현
    public void Cancel(Scanner scan, int phase, Line[] lines){
        boolean exist;

        for(int i=0;i<1;i++){
            try{
                System.out.print("좌석 유형 선택 S(1) A(2) B(3) : ");
                phase = 2;
                int line = scan.nextInt();
                scan.nextLine();
                exist = CheckOption(phase, line);
                if(exist){
                    PrintLine(lines, line);
                    boolean isReserve = CheckReserve(lines[line - 1]);
                    if(isReserve){
                        DeleteSeat(scan, lines[line - 1]);
                    }
                    else{
                        if(line == 1){
                            System.out.println("S 줄에 예약된 인원이 없습니다");
                        }
                        else if(line == 2){
                            System.out.println("A 줄에 예약된 인원이 없습니다");
                        }
                        if(line == 3){
                            System.out.println("B 줄에 예약된 인원이 없습니다");
                        }
                    }

                }
                else{
                    System.out.println("없는 좌석 유형입니다");
                    i--;
                }

            }catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다(Cancel Seat)");
                scan.nextLine();
                i--;
            }
        }
    }

    //finish 구현
    public boolean Finish(){
        System.out.println("종료합니다");
        
        return false;
    }

    public void Run(){
        Scanner scan = new Scanner(System.in);
        Line [] lines = MakingTheater();

        System.out.println("==========예약 시스템==========");
        System.out.println("");
        boolean flag = true;
        while(flag){
            int phase;
            boolean exist;

            for(int i=0;i<1;i++){
                try{
                    System.out.print("예약(1) 조회(2), 취소(3), 종료(4) : ");
                    phase = 1;
                    int menuInput = scan.nextInt();
                    exist = CheckOption(phase, menuInput);
                    if(exist){
                        if(menuInput == 1){
                            Reserve(scan, phase, lines);
                        }
                        else if(menuInput == 2){
                            for(int j=0;j<lines.length;j++){
                                PrintLine(lines, j + 1);
                            }
                            System.out.println("");
                            System.out.println("=====조회를 완료하였습니다=====");
                        }
                        else if(menuInput == 3){
                            Cancel(scan, phase, lines);
                        }
                        else if(menuInput == 4){
                            flag = Finish();
                        }
                    }
                    else {
                        System.out.println("없는 기능입니다");
                        i--;
                    }
                }catch(InputMismatchException e){
                    System.out.println("잘못된 입력입니다(Menu)");
                    scan.nextLine();
                    i--;
                }
            }
        }

        scan.close();
    }
}

public class App {
    public static void main(String[] args) {

        ReserveSYS system = new ReserveSYS();

        system.Run();

    }
}
