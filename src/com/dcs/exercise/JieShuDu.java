package com.dcs.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
写一个程序通过填充空格来解决数独。

空格用 '.' 表示。

你可以假设只有唯一解。
 */
public class JieShuDu {
    public static void solveSudoku(char[][] board) {
        List<ShuDuKong[]> rows = new ArrayList<>();
        List<ShuDuKong[]> lins = new ArrayList<>();
        List<ShuDuKong[]> nines = new ArrayList<>();
        int[][] ni = {{0,1,2},{3,4,5},{6,7,8}};
        for (int i = 0;i < 9;i++){
            ShuDuKong[] row = new ShuDuKong[9];
            ShuDuKong[] line = new ShuDuKong[9];
            ShuDuKong[] nine = new ShuDuKong[9];
            rows.add(row);
            lins.add(line);
            nines.add(nine);
        }
        Stack<ShuDuKong> kong = new Stack<>();
        int[] res = new int[9];
        for (int i = 0;i < board.length; i++){
            for (int j = 0;j < board[i].length;j++){
                ShuDuKong a = new ShuDuKong(0);
                if (board[i][j] != '.') {
                    a.value = board[i][j] - '0';
                }else {
                   kong.push(a);
                }
                rows.get(i)[j] = a;
                a.row = rows.get(i);
                lins.get(j)[i] = a;
                a.line = lins.get(j);
                nines.get(ni[i/3][j/3] )[ni[i%3][j%3]] = a;
                a.nine = nines.get(ni[i/3][j/3]);
            }
        }
        ShuDuKong a = kong.pop();
        for (int i = 0;i < a.row.length;i++){
            ShuDuKong x = a.row[i];
            ShuDuKong y = a.line[i];
            ShuDuKong z = a.nine[i];
            if (x.value != 0){
                res[x.value - 1] = res[x.value - 1]+ 1;
            }
            if (y.value != 0){
                res[y.value - 1] = res[y.value - 1] + 1;
            }
            if (z.value != 0){
                res[z.value - 1] = res[z.value - 1] + 1;
            }
        }
        for (int i = 0;i < res.length;i++){
            if (res[i] <= 3){
                a.value = i + 1;
                boolean b = found(kong);
                if (b) break;
                else a.value = 0;
            }
        }
        for (int i = 0;i < board.length; i++){
            for (int j = 0;j < board[i].length;j++){
                board[i][j] = (char) (rows.get(i)[j].value + '0');
                System.out.println(board[i][j]);
            }
        }
    }
    public static boolean found(Stack<ShuDuKong> kong){
//        System.out.println(kong.size());
        if (kong.empty()) return true;
        int[] res = new int[9];
        boolean b = false;
        ShuDuKong a = kong.pop();
        for (int i = 0;i < a.row.length;i++){
            ShuDuKong x = a.row[i];
            ShuDuKong y = a.line[i];
            ShuDuKong z = a.nine[i];
            if (x.value != 0){
                res[x.value - 1] = res[x.value - 1] + 1;
            }
            if (y.value != 0){
                res[y.value - 1] = res[y.value - 1] + 1;
            }
            if (z.value != 0){
                res[z.value - 1] = res[z.value - 1] + 1;
            }
        }
        for (int i = 0;i < res.length;i++){
            if (res[i] > 3){
                b = false;
                kong.push(a);
//                System.out.println(b+"...................");
//                System.out.println(kong.size());
                return b;
            }
            if (res[i] <= 0){
                a.value = i + 1;
//                System.out.println(a.value);
                b = found(kong);
                if (b){
                    return true;
                }
                else a.value = 0;
            }
        }
        if (!b) kong.push(a);
        return b;
    }

    public static void main(String[] args) {
        char[][] a = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(a);
    }
}
class ShuDuKong{
    int value;
    public ShuDuKong(int value){
        this.value = value;
    }
    ShuDuKong[] row;
    ShuDuKong[] line;
    ShuDuKong[] nine;
}