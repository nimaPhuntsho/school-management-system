public class Staff extends Person{
    private String officeLocation;
    private final String ESCAPE_CHAR = "\n";


    public Staff(String name, String email, int age, String officeLocation) {
        super(name, email, age);
        this.officeLocation = officeLocation;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String toString() {
        String name = "NAME : " + this.getName();
        String email = "EMAIL : " + this.getEmail();
        int age = this.getAge();
        String location = "OFFICE LOCATION : " + getOfficeLocation();

        return ESCAPE_CHAR + name + ESCAPE_CHAR + email + ESCAPE_CHAR + "AGE : " + age + ESCAPE_CHAR + location;
    }
}
