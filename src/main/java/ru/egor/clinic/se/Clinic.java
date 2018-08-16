package ru.egor.clinic.se;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    //private final Client [] clients;
    private List<Client> clients;

    public Clinic() {
        this.clients = new ArrayList<Client>();
    }


    public List<Client> getClients() {
        return this.clients;
    }

    public void addClient(int id, String name, Pet pet) throws UserUncorrectedException {
        getClients().add(new Client(id,name,pet));

        }
        public void showList(){
            for(Client cl : getClients()) {
                if(cl!=null) {
                    System.out.println(cl.getId() + " " + cl.getName() + " " + cl.getPet().toString());
                }
            }
            System.out.println("===================================================================");
        }

        public void searchForNameClient(String nameClient){
        boolean res = false;
            for(int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getName().equals(nameClient)) {
                    System.out.println(clients.get(i).toString());
                    System.out.println("===================================================================");
                    res = true;
                }
            }
            if(!res){
                System.out.println("Client not found!!!");
                System.out.println("===================================================================");
            }
        }

        public void searchForNamePet(String namePet){
            boolean res = false;
            for(int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getPet().getName().equals(namePet)) {
                    System.out.println(clients.get(i).toString());
                    System.out.println("===================================================================");
                    res = true;
                }
            }
            if(!res){
                System.out.println("Client not found!!!");
                System.out.println("===================================================================");
            }
        }

        public void updateClient(int id, String nameClient){
            boolean res = false;
            for(int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId() == (id)) {
                    clients.get(i).setName(nameClient);
                    showList();
                    res = true;
                }
            }
            if(!res){
                System.out.println("Id is not corrected!!");
                System.out.println("===================================================================");
            }
        }

        public void updateClient(int id, String nameClient, String namePet){
            boolean res = false;
            for(int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId() == (id)) {
                    clients.get(i).setName(nameClient);
                    Pet pet = clients.get(i).getPet();
                    pet.setName(namePet);
                    clients.get(i).setPet(pet);
                    showList();
                    res = true;
                }
            }
            if(!res){
                System.out.println("Id is not corrected!!");
                System.out.println("===================================================================");
            }
        }

}
