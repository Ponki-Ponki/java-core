package main;

import main.exception.MyArraySizeException;

import java.lang.reflect.Array;
import java.util.Random;

public class CArray {
    String[][] arr;
    Random r = new Random();
    public CArray() {
        this.arr = new String[r.nextInt(3, 5)][r.nextInt(3, 5)];
        fillingArray();
    }

    public String[][] getArr() {
        return arr;
    }

    public void init() throws MyArraySizeException {
        if (arr.length != 4 || arr[0].length != 4){
            throw new MyArraySizeException("Не правильные размеры массива!",arr.length,arr[0].length);
        }
        else{
            System.out.println("Массив 4х4");
        }
    }

    public void fillingArray(){
        String[] a = new String[]{"a","1","2","3","4","5","6","7","8","9","0"};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                arr[i][j] = Integer.toString(r.nextInt(0,10));
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = a[r.nextInt(0,10)];
            }
        }
    }

    public  void print(){
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

}
