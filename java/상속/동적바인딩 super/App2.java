class Shape1{
    public void paint(){
        draw();
    }

    public void draw(){
        draw();         //동적 바인딩된 메소드가 있다면 호출됨(업 캐스팅 되지 않은 레퍼런스 변수로 접근해도 해당 객체의 클래스에 포함된 메소드가 호출됨)
        System.out.println("shape");
    }
}

class Circle1 extends Shape1{
    public void paint(){
        super.draw();   //Shape1의 draw() 호출
    }

    public void draw(){
        System.out.println("circle");
    }
}

class App2{

    public static void main(String args[]){
        Shape1 s = new Circle1();   //Circle의 draw()가 호출됨
        Circle1 c = new Circle1();  //업 캐스팅 되지 않은 객체로 슈퍼 클래스에 접근해도 Circle의 draw()가 호출됨
        //s.paint();
        //c.paint();

        Shape1 s2 = new Shape1();   //이 경우엔 Shape1을 가리키기 때문에 동적 바인딩된 메소드가 없음
        s2.paint();

    }
}