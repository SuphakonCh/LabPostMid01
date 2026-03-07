package com.library.lab5;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowedBookCount = 0;
//    private static final int MAX_BORROW_LIMIT = 3;
    private MembershipStrategy membershipStrategy;

    public Member(String memberID, String memberName, MembershipStrategy membershipStrategy) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.membershipStrategy = membershipStrategy;
    }

    public void setMembershipStrategy(MembershipStrategy membershipStrategy) {
        this.membershipStrategy = membershipStrategy;
    }

    public boolean canBorrow() {
        if (membershipStrategy.hasUnlimitedBorrowing()){
            return true;
        }
        if (borrowedBookCount < membershipStrategy.getBorrowLimit()) {
            return true;
        } else {
            return false;
        }
    }
    public void incrementBorrowCount() {
        borrowedBookCount++;
    }
    public void decrementBorrowCount() {
        if (borrowedBookCount > 0) {
            borrowedBookCount--;
        }
    }
    public double calculateLateFee(double baseFee){
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }
    public void displayMemberInfo(){
        System.out.println("MEMBER INFORMATION");
        System.out.println("ID: " + memberID);
        System.out.println("Name: " + memberName);
        System.out.println("Membership Type: " + membershipStrategy.getMembershipType());
        System.out.println("Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");
        if (membershipStrategy.hasUnlimitedBorrowing()) {
            System.out.println("Borrow Limit: Unlimited");
        } else {
            System.out.println("Borrow Limit: " + membershipStrategy.getBorrowLimit());
        }
        System.out.println("Currently Borrowed: " + borrowedBookCount);
        System.out.println("Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }

    public String getMemberID() {
        return memberID;
    }
    public String getMemberName() {
        return memberName;
    }
    public String getName(){
        return memberName;
    }
    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }
}