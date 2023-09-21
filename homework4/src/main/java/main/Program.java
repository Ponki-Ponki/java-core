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
    private static int parseInt(String value, int i,int j) throws MyArrayDataException {
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            System.out.printf("%s X:%d Y:%d",e.getMessage(),i,j);
            System.out.println();
            return 0;
        }
    }

    public static int sumArray(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    sum += parseInt(arr[i][j],i,j);
                }
            }
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
