package main.exception;

public class MyArrayDataException extends MyArraySizeException{

    private final Integer i;
    private final Integer j;
    public MyArrayDataException(String message, Integer i, Integer j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public Integer getJ() {
        return j;
    }

    public Integer getI() {
        return i;
    }
}
