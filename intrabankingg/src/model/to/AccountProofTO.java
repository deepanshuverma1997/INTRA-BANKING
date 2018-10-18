package model.to;

public class AccountProofTO {

    private int srno;
    private int proofid;
    private String accountid;
    private String proofvalue;

    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public int getProofid() {
        return proofid;
    }

    public void setProofid(int proofid) {
        this.proofid = proofid;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getProofvalue() {
        return proofvalue;
    }

    public void setProofvalue(String proofvalue) {
        this.proofvalue = proofvalue;
    }
}
