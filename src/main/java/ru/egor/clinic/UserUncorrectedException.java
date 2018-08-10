package ru.egor.clinic;

public class UserUncorrectedException extends Exception{

    public UserUncorrectedException(final String message){
        super(message);
    }
}
