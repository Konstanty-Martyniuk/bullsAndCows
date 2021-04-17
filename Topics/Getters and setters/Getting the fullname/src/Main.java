class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if ("".equals(this.firstName) && "".equals(this.lastName)) {
            return "Unknown";
        } else if ("".equals(this.firstName)) {
            return lastName;
        } else if ("".equals(this.lastName)) {
            return firstName;
        } else {
            return this.firstName + " " + this.lastName;
        }
    }
}