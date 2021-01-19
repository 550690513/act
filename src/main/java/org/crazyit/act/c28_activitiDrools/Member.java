package org.crazyit.act.c28_activitiDrools;

import java.io.Serializable;

public class Member implements Serializable {

    private String identity;

    // 消费金额
    private int amount;

    // 优惠后的金额
    private double discount;

    // 规则计算后的金额
    private double result;

    public Member() {
    }

    public Member(String identity, int amount) {
        this.identity = identity;
        this.amount = amount;
    }

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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        this.result = amount * discount;
        return result;
    }

    public static void main(String[] args) {
        Member m = new Member();
        m.setAmount(100);
        m.setDiscount(0.8);
        System.out.println(m.getResult());
    }
}
