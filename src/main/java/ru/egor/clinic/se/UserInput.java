package ru.egor.clinic.se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Clinic cl = new Clinic();
    private int id;
    private String name;
    private String pet;
    private String petName;
    private boolean exit = true;



    public void startingInput() throws IOException, UserUncorrectedException {
        cl.addClient(1, "Ivanov", new Dog("Barbos"));
        cl.addClient(2, "Petrov", new Cat("Vaska"));
        while (exit) {
            System.out.println("Select the operation: ");
            System.out.println("a - add client(id, name, pet, pet name)");
            System.out.println("sh - show all client");
            System.out.println("sn - search for client name ");
            System.out.println("snp - search for pet name");
            System.out.println("uc - update client(id, name)");
            System.out.println("ucp - update client/pet(id, name, pet name)");
            System.out.println("exit - exit");
            System.out.println("===================================================================");
            String operation = reader.readLine();
            switchOperation(operation);
        }

    }

    public void switchOperation(String oper) throws IOException  {
        switch (oper){
            case "exit" : closeProgram();break;
            case "a" :  System.out.println("input id");
                        try {
                            id = Integer.parseInt(reader.readLine());
                        }catch (NumberFormatException e){
                            try {
                                throw new UserUncorrectedException("You mast input integer number");
                            } catch (UserUncorrectedException e1) {
                                e1.printStackTrace();
                                switchOperation("a");
                            }

                        }
                        System.out.println("input client name");
                        name = reader.readLine();
                        System.out.println("input pet type");
                        pet = reader.readLine();
                        System.out.println("input pet name");
                        petName = reader.readLine();
                        if(pet.equals("Dog")||pet.equals("dog")){
                            try {
                                cl.addClient(id,name,new Dog(petName));
                            } catch (UserUncorrectedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(pet.equals("Cat")||pet.equals("cat")){
                            try {
                                cl.addClient(id,name,new Cat(petName));
                            } catch (UserUncorrectedException e) {
                                e.printStackTrace();
                            }
                        }
                        cl.showList();
                        break;
            case "sh" : cl.showList();break;
            case "sn" : System.out.println("input client name");
                        name = reader.readLine();
                        cl.searchForNameClient(name);break;
            case "snp" : System.out.println("input pet name");
                        petName = reader.readLine();
                        cl.searchForNamePet(petName);break;
            case "uc" : System.out.println("input id");
                        id = Integer.parseInt(reader.readLine());
                        System.out.println("input new client name");
                        name = reader.readLine();
                        cl.updateClient(id,name);
                        break;
            case "ucp" : System.out.println("input id");
                        id = Integer.parseInt(reader.readLine());
                        System.out.println("input client name");
                        name = reader.readLine();
                        System.out.println("input pet name");
                        petName = reader.readLine();
                        cl.updateClient(id,name,petName);
                        break;
        }
    }

    public void closeProgram() throws IOException {
                System.out.println("Goodbye!!!");
                exit = false;
                reader.close();
        }

}
