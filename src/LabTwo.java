import java.lang.reflect.Array;

public class LabTwo {

    public static short[][] scalarMatr(short[][] matr, int a){
        for(int i = 0; i < matr.length; i++){
            for(int j = 0; j < matr[i].length; j++){
                matr[i][j] =  (short)(a * matr[i][j]);
//              Не обробляється варіант, переповнення типу шорт
            }
        }
        return matr;
    }

    public static short findSum(short[][] matr){
        short res = 0;
        short[][] tMatr = new short[matr.length][matr[1].length];
        short[] minlist = new short[matr[1].length];

        for(int i = 0; i < matr.length; i++){
            for(int j = 0; j < matr[i].length; j++){
                tMatr[i][j] = matr[j][i];
            }
        }

        for(int i = 0; i < tMatr.length; i++){
            minlist[i] = tMatr[i][0];

            for(int j = 0; j < tMatr[i].length; j++){
                if(tMatr[i][j] < minlist[i]){
                    minlist[i] = tMatr[i][j];
                }
            }
        }

        for(int i = 0; i < minlist.length; i++){
            res += minlist[i];
        }

        return res;
    }

    public static void main(String[] args) {
        /**
         * Second Java Lab
         * @author Yevhenii Shchuryk
         * C5 = 9129 % 5 = 4--->0 C = axB, a - const
         * C7 = 9129 % 7 = 1--->2 short
         * C11= 9129 % 11= 10-->0 Sum of min in each column
         * Варіант змінено на наступний, адже вже колись виконував його(ООП)
         */

        final int a = 3;
        short[][] matr ={{1, 3, 4, 1},
                         {2, 4, 1, 0},
                         {0, 7, 1, 4},
                         {3, 8, 5, 2}};

        scalarMatr(matr, a);
        short sum = findSum(matr);
        System.out.println(sum);
    }
}
