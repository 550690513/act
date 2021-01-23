package org.crazyit.act.c31_02_activitiMvel;

public class Sale {

    private String identity;

    private int amount;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double doDiscount(double discount) {
        return this.amount * discount;
    }

}
