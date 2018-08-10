package ru.egor.clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartingPrograms {
    public static void main(String[] args) throws UserUncorrectedException, IOException {

        UserInput ui = new UserInput();
        ui.startingInput();
        //ui.closeProgram();

    }

}
