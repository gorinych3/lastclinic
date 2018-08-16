package ru.egor.clinic.se;

public class UserUncorrectedException extends Exception{

    public UserUncorrectedException(final String message){
        super(message);
    }
}
