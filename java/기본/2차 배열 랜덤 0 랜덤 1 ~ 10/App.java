
public class App {

    //중복 제거하는 함수
    public static void check(int[] ary, int i, int max) {
        for (int j = 0; j < i; j++) {
            if (ary[i] == ary[j]) {
                ary[i] = (int) (Math.random() * max + 1);
                check(ary, i, max);
            }
        }
    }


    public static void main(String[] args) {
    //0이 들어갈 index
        int target0[] = new int[6];
        for (int i = 0; i < target0.length; i++) {
            target0[i] = (int) (Math.random() * 15 + 1);
            check(target0, i, 15);
            System.out.print(target0[i] + " ");
        }

        System.out.print("\n");
    //1 ~ 10이 들어갈 index
        int targetNum[] = new int[10];
        int tN = 0;
        for(int i=0;i<16;i++){
            for(int j=0;j<target0.length;j++){
                if(i == target0[j]){
                    break;
                }
                else if(j == target0.length - 1){
                    targetNum[tN] = i;
                    tN++;
                }
            }
        }
    //2차 배열에 들어갈 값
        int inputNum[] = new int [10];
        for(int i=0;i<inputNum.length;i++){
            inputNum[i] = (int)(Math.random()*10 + 1);
            check(inputNum, i, inputNum.length);
        }

        for(int i=0;i<10;i++){
            System.out.print(targetNum[i] + " ");
        }

        System.out.print("\n");
    //2차 배열 생성
        int output[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = 4 * i + j;
                for(int k=0;k<6;k++){
                    if(x == target0[k]){
                        output[i][j] = 0;
                    }
                }
                for(int k=0;k<10;k++){
                    if(x == targetNum[k]){
                        output[i][j] = inputNum[k];
                    }
                }
                System.out.print(output[i][j] + "\t");
            }
            System.out.print("\n");
        }


    }
}