package model.to;

public class AccountTypeTO {

    private String typeid;
    private String typename;
    private String rolename;
    private float interestrate;
    private float minimum;

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public float getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(float interestrate) {
        this.interestrate = interestrate;
    }

    public float getMinimum() {
        return minimum;
    }

    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }
}
