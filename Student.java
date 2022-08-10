public class Student extends Person{
    private int studentNumber;
    private String degree;
    private double GPA;

    public Student () {

    }

    public Student(String name, String email, int age, int studentNumber, String degree) {
        super(name, email, age);
        setStudentNumber(studentNumber);  //must have 8 numeric digits.
        this.degree = degree;
    }
    public int getStudentNumber() {
        return studentNumber;
    }

    //an Illegal Argument exception is thrown with a message on using invalid input.
    public void setStudentNumber(int studentNumber) {
        if (studentNumber <= 0) {
            throw new IllegalArgumentException("Student number cannot be 0 or less than 0");
        } else if (checkLength(studentNumber)) {
            this.studentNumber = studentNumber;
        }
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getGPA() {
        return GPA;
    }

    //an Illegal Argument exception is thrown with a message on using invalid input.
    public void setGPA(double GPA) {
        if (GPA < 0 || GPA > 7) {
            throw new IllegalArgumentException("GPA cannot be less than 0 or more than 7");
        } else this.GPA = GPA;
    }

    //The method will check the length of the int value and in this case the studentID should only have 8 digits.
    public boolean checkLength (int number) {
        boolean result = false;
        String numberValue = Integer.toString(number);
        char [] args = numberValue.toCharArray();
        if (args.length == 8) {

        } else {
            throw new IllegalArgumentException("Student ID must contain 8 digits");
        }
        return result = true;
    }
}