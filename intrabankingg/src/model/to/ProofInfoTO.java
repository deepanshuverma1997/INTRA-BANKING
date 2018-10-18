package model.to;

public class ProofInfoTO {

    private int proofid;

    @Override
    public String toString() {
        return proofname;
    }
    private String proofname;
    private String totaldigits;

    public String getTotaldigits() {
        return totaldigits;
    }

    public void setTotaldigits(String totaldigits) {
        this.totaldigits = totaldigits;
    }

    public int getProofid() {
        return proofid;
    }

    public void setProofid(int proofid) {
        this.proofid = proofid;
    }

    public String getProofname() {
        return proofname;
    }

    public void setProofname(String proofname) {
        this.proofname = proofname;
    }

}
