package PetStore;

import java.util.ArrayList;
import java.util.Scanner;

public class PetStoreDriver {
    public static void main(String[] args){
        PetStore petStore = new PetStore();
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<String>();
        int num  = 0;
        while(num!=6){
            System.out.println("Please select from the following menu options, by typing a number:");
            System.out.println("\t 1. Check Member Status");
            System.out.println("\t 2. Add Something to your Cart");
            System.out.println("\t 3. Get total Purchase Value");
            System.out.println("\t 4. Checkout");
            System.out.println("\t 5. Register a New Member");
            System.out.println("\t 6. Exit");

            num = keyboard.nextInt();
            keyboard.nextLine();

            switch(num){
                case 1:
                    checkMemberStatus(petStore,keyboard);
                    break;
                case 2:
                    purchase(petStore, keyboard, cart);
                    break;
                case 3:
                    System.out.println("Your total purchase is: " + getTotalPurchases(cart));
                    break;

                case 4:
                    checkout(cart,petStore, keyboard);
                    break;
                case 5:
                    System.out.println("Premium member? (Y/N)");
                    char letter = keyboard.next().charAt(0);
                    keyboard.nextLine();
                    if (letter == 'Y' || letter == 'y') {
                        registerNewMember(petStore, keyboard, 1);
                    } else {
                        registerNewMember(petStore, keyboard, 0);
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3, 5, or 6");
            }

        }

    }

    private static void checkout(ArrayList<String> cart, PetStore petStore, Scanner scan) {
        for(int i= 0; i<cart.size(); i++){
            System.out.println(cart.get(i));
        }
        System.out.println("Your total is " + getTotalPurchases(cart));
        System.out.println("Thank you!");
        System.out.println("Please come again");
        System.exit(0);
    }


    private static void registerNewMember(PetStore petStore, Scanner scan, int premium) {
        System.out.println("Input the  name of the new member: ");
        String name = scan.nextLine();
        System.out.println("How many purchases have been made?");
        int purchases = scan.nextInt();
        scan.nextLine();
        if(premium ==0){
            petStore.addNewMember(name, false, purchases);
        }
        else {
            petStore.addNewMember(name, true, purchases);
        }
    }

    private static double getTotalPurchases(ArrayList<String> cart) {
        double sum = 0;
        for(int i = 0; i<cart.size(); i++){
            String[] expressions = cart.get(i).split(" ");
            double price = Double.parseDouble(expressions[2]);
            //System.out.println(String.format("%.2f", price));
            sum = sum + price;
        }
        return sum;
    }

    private static void checkMemberStatus(PetStore petStore, Scanner scan){
        int memberNumber = 1;
        System.out.println("Select the Member.");
        System.out.println("Members: ");
        for (int i = 0; i<petStore.getMembersList().size(); i++){
            System.out.println(memberNumber + ". " + petStore.getMembersList().get(i).getName());
            memberNumber++;
        } System.out.println("Premium Members: ");
        for(int i = 0; i < petStore.getPremiumMembersList().size(); i++){
            System.out.println(memberNumber + ". " +petStore.getPremiumMembersList().get(i).getName());
        }
        System.out.println("Input the member number of the selected member: ");
        int selection = scan.nextInt();
        scan.nextLine();petStore.displayMemberStatus(selection);
    }

    private static void purchase(PetStore petStore, Scanner scan, ArrayList<String> cart) {
        int id = 1;
        System.out.println("select the pet you wish to add to your cart ");
        System.out.println("Dogs: ");
        for (int i = 0; i < petStore.getDogsInventory().size(); i++) {
            System.out.println(id + ". " + petStore.getDogsInventory().get(i).getName());
            id++;
        }
        System.out.println("Cats: ");
        for (int i = 0; i < petStore.getCatsInventory().size(); i++) {
            System.out.println(id + ". " + petStore.getDogsInventory().get(i).getName());
            id++;
        }

        System.out.println("GoldFishes: ");
        for (int i = 0; i < petStore.getGoldFishesInventory().size(); i++) {
            System.out.println(id + ". " + petStore.getGoldFishesInventory().get(i).getName());
            id++;
        }

        System.out.println("Input the id number of the selected pet");
        int selection = scan.nextInt();
        scan.nextLine();
        System.out.println(petStore.getCartItem(selection));
        petStore.decrementInventory(selection);
        cart.add(petStore.getCartItem(selection));
    }
}




