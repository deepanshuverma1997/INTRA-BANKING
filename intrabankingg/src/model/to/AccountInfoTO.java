package model.to;

import java.sql.Date;

public class AccountInfoTO {
 private String accountid;
    private String branchid;
    private Date openingdate;
    private float initial_balance;    
    private float current_balance;
    private String name;
    private String fathername;
    private Date dob;
    private String contactno;
    private String address;

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public Date getOpeningdate() {
        return openingdate;
    }

    public void setOpeningdate(Date openingdate) {
        this.openingdate = openingdate;
    }

    public float getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(float initial_balance) {
        this.initial_balance = initial_balance;
    }

    public float getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(float current_balance) {
        this.current_balance = current_balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){
        return accountid;
    }
}
