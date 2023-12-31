package main.exception;

public class MyArraySizeException extends Exception{
    private final Integer sizeX;
    private final Integer sizeY;

    public MyArraySizeException(String message ,Integer sizeX, Integer sizeY) {
        super(message);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }


    public Integer getSizeX() {
        return sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }
}
