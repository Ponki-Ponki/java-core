package main;

import main.exception.MyArrayDataException;
import main.exception.MyArraySizeException;

public class Program {
    public static void main(String[] args) {
        CArray arr = new CArray();
        try {
            arr.init();
            arr.fillingArray();
            arr.print();
            System.out.println(sumArray(arr.getArr()));
        }
        catch (MyArrayDataException e){
            System.out.printf("%s    %d x %d \n",e.getMessage(),e.getI(),e.getJ());
        }
        catch (MyArraySizeException  e){
            System.out.printf("%s %d x %d \n",e.getMessage(), e.getSizeX(),e.getSizeY());
        }
    }
    public static int sumArray(String[][] arr) throws MyArrayDataException {
        int sum =0;
        try {
            for (String[] strings : arr) {
                for (String string : strings) {
                    sum += Integer.parseInt(string);
                }
            }
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
