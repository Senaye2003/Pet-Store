package PetStore;

import java.util.ArrayList;

public class PetStore {
    ArrayList<Cat> catsInventory;
    ArrayList<Dog> dogsInventory;

    ArrayList<GoldFish> goldFishesInventory;
    ArrayList<Member> membersList;
    ArrayList<PremiumMember> premiumMembersList;

    public PetStore() {
        membersList = new ArrayList<Member>();
        premiumMembersList = new ArrayList<PremiumMember>();
        generateInventory();
        generateMembers();

    }

    public ArrayList<Cat> getCatsInventory() {
        return catsInventory;
    }

    public ArrayList<Dog>getDogsInventory(){
        return dogsInventory;
    }

    public ArrayList<GoldFish>getGoldFishesInventory(){
        return goldFishesInventory;
    }

    public ArrayList<Member> getMembersList(){
        return membersList;
    }

    public ArrayList<PremiumMember> getPremiumMembersList(){
        return premiumMembersList;
    }
    private void generateInventory() {
      catsInventory = new ArrayList<Cat>();
      dogsInventory = new ArrayList<Dog>();
      goldFishesInventory = new ArrayList<GoldFish>();

      dogsInventory.add(new Dog("buoy", 12, 19.3,4, 30.5));
      dogsInventory.add(new Dog("bro", 11, 15.2,1, 45.0));

      catsInventory.add(new Cat("damn", 3,4.5,2, 123 ));
      catsInventory.add(new Cat("nova", 2,19,14, 98 ));

      goldFishesInventory.add(new GoldFish("jayla", 1,1.2,2, 12 ));
      goldFishesInventory.add(new GoldFish("dru", 2,9,1, 90 ));

    }
    private void generateMembers() {
        membersList.add(new Member("Senaye Weldeberhan",  1));
        membersList.add(new Member("Pavan Weldeberhan",  2));

        premiumMembersList.add(new PremiumMember("Lionel Messi",  1, false));
        premiumMembersList.add(new PremiumMember("Emi Martinez",  4, true));
    }
    public void addNewMember(String name, boolean premium, int numOfItems){
            if(premium){
                premiumMembersList.add(new PremiumMember(name, numOfItems, true));
            }
            else{
                membersList.add(new Member(name, numOfItems));
            }
    }


    public void decrementInventory(int id){
        if(id > catsInventory.size() + dogsInventory.size()){
            id = id - catsInventory.size() - dogsInventory.size() - 1;
            goldFishesInventory.get(id).setStock( goldFishesInventory.get(id).getStock() - 1);
            System.out.println("There are now " +  goldFishesInventory.get(id).getStock() + " in stock");
        } else if (id > catsInventory.size()){
            id = id - catsInventory.size() - 1;
            dogsInventory.get(id).setStock(dogsInventory.get(id).getStock() - 1);
            System.out.println("There are now " + dogsInventory.get(id).getStock() + " in stock");
        } else {
            id = id - 1;
            catsInventory.get(id).setStock(catsInventory.get(id).getStock() - 1);
            System.out.println("There are now " + catsInventory.get(id).getStock() + " in stock");
        }
    }

    public String getCartItem(int id){
        if(id > catsInventory.size() + dogsInventory.size()){
            id = id - catsInventory.size() - dogsInventory.size() - 1;
            return goldFishesInventory.get(id).getName() + " - " + String.format("%.2f", goldFishesInventory.get(id).getPrice());
        } else if (id > catsInventory.size()){
            id = id - catsInventory.size() - 1;
            return dogsInventory.get(id).getName() + " - " + String.format("%.2f", dogsInventory.get(id).getPrice());
        } else {
            id = id - 1;
            return catsInventory.get(id).getName() + " - " + String.format("%.2f", catsInventory.get(id).getPrice());
        }
    }


    public void displayMemberStatus(int memberId){
        if(memberId > membersList.size()){
            memberId = memberId - membersList.size() - 1;
            System.out.println(premiumMembersList.get(memberId).getName() );
            System.out.println("Purchases: " + premiumMembersList.get(memberId).getNumPurchases());
            System.out.println("Paid Dues: " + premiumMembersList.get(memberId).hasPaidDues());
        } else {
            memberId = memberId - 1;
            System.out.println(membersList.get(memberId).getName());
            System.out.println("Purchases: " + membersList.get(memberId).getNumPurchases());
        }
    }





}
