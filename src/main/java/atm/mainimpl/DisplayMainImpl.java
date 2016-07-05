package atm.mainimpl;

import atm.services.Display;
import consts.Consts;
import consts.Operation;

import java.util.Scanner;

public class DisplayMainImpl implements Display{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void show(String s) {
        System.out.println(s);
    }


    @Override
    public int getAmount() {
        System.out.println("Please, insert money Amount");
        return sc.nextInt();
    }

    @Override
    public String getPin() {
        System.out.println("Please, insert your PIN");
        return sc.nextLine();

    }

    @Override
    public Operation getOperation() {
        System.out.println("Please insert operation");
        System.out.println("1: Withdraw money");
        System.out.println("2: Deposit money");
        System.out.println("3: Info about user");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                return Operation.WITHDRAW;
            case 2:
                return Operation.DEPOSIT;
            case 3:
                return Operation.INFO;
            default:
                return Operation.WRONG_OPERATION;
        }
    }
}
