package com.library.lab02;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowedBookCount = 0;
    private static final int MAX_BORROW_LIMIT = 3;

    public Member(String memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }
    public boolean canBorrow() {
        return borrowedBookCount < MAX_BORROW_LIMIT;
    }
    public void incrementBorrowCount() {
        borrowedBookCount++;
    }
    public void decrementBorrowCount() {
        if (borrowedBookCount > 0) {
            borrowedBookCount--;
        }
    }

    public String getMemberID() {
        return memberID;
    }
    public String getMemberName() {
        return memberName;
    }
}