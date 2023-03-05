package PetStore;

public class Member {
   String name;
    int numPurchases;

    public Member(String name,  int numPurchases) {
        this.name = name;
        this.numPurchases = numPurchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPurchases(){return numPurchases;}
    public void setNumPurchases(int numPurchases){this.numPurchases=numPurchases;}


}
