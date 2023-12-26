package petStore;

public class PremiumMember extends Member {

    boolean hasPaidDues;

    public PremiumMember(String name, int numPurchases, boolean hasPaidDues) {
        super(name, numPurchases);
        this.hasPaidDues = hasPaidDues;
    }

    public boolean hasPaidDues() {
        return hasPaidDues;
    }

    public void setHasPaidDues(boolean hasPaidDues) {
        this.hasPaidDues = hasPaidDues;
    }

    public void incrementPurchases(int numPurchases) {
        this.numPurchases = this.numPurchases + numPurchases;
    }
}