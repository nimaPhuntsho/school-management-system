import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Unit extends Student {
    private String unitName;
    private String unitCode;

    //the list will store student objects
    private LinkedList <Student> students = new LinkedList();

    //the hashmap will store the details of staff members, their role as key and the staff objects as a value.
    private HashMap <String, Staff> staffMembers = new HashMap<>();
    private final String COMMA = ",";
    private final String ESCAPE_CHAR = "\n";

    private Lock lock = new ReentrantLock();

    //Constructor with parameters
    public Unit(String unitName, String unitCode) {
        setUnitName(unitName);
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    //If the unit name contains any integers values, it will throw an exception.
    public void setUnitName(String unitName) {
        if (checkInteger(unitName)) {
            throw new IllegalArgumentException("Unit name must not contain integer values");
        } else {
            this.unitName = unitName;
        }
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    //The method will add a student object in students list (Linked list).
    public void addStudent (Student studentName) {
        lock.lock();
        try {
            this.students.add(studentName);
        } finally {
            lock.unlock();
        }
    }

    //The method will remove a student object in students list (Linked list).
    public void removeStudent (Student studentName) {
        lock.lock();
        try {
            this.students.remove(studentName);
        } finally {
            lock.unlock();
        }
    }

    /*
    * It will return total number of students enrolled in the unit. And if there is 0 student in the list it will
    * throw a Null pointer exception.
    * */
    public int numberOfStudents () {
        int checkStudents = students.size();
        if (checkStudents == 0) {
            throw new NullPointerException("List is empty");
        } else {
            return this.students.size();
        }
    }

    //The method prints all the details of the students enrolled in a particular unit.
    public void printStudents () {
        System.out.println("<- STUDENT DETAILS ->");
        Iterator <Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student studentDetails = iterator.next();
            System.out.println("Name        : " + studentDetails.getName());
            System.out.println("Email       : " + studentDetails.getEmail());
            System.out.println("Age         : " + studentDetails.getAge());
            System.out.println("Student ID  : " + studentDetails.getStudentNumber());
            System.out.println("Degree      : " + studentDetails.getDegree());
            System.out.println("-----------------------------------" + ESCAPE_CHAR);
        }
    }

    //It returns student linked list.
    public LinkedList <Student> allStudents () {
        return this.students;
    }

    /*It sorts the students list using the comparator interface implemented in SortStudent class. Two instance variables
    are used for sorting the list.*/
    public void sortStudents () {
        Collections.sort(students, new SortStudents());
    }

    //The method adds a staff object to the hashmap (staffMembers).
    public void addStaff (String role, Staff staffMember) {
        this.staffMembers.put(role, staffMember);
    }

    //The method removes a staff object to the hashmap (staffMembers).
    public void removeStaff (String role, Staff staffMember) {
        this.staffMembers.remove(role, staffMember);
    }

    //It prints the staff details on the console.
    public void printStaff () {
        int checkStaffs = staffMembers.size();
        if (checkStaffs != 0) {
            System.out.println("S T A F F   D E T A I L S : ");
            Iterator <Map.Entry <String, Staff>> iterator = staffMembers.entrySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + ESCAPE_CHAR);
            }
        } else {
            throw new NullPointerException("The list is empty, add staffs to print");
        }
    }

    public void exportStudents ()  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("student-details.txt"));
            for (int i = 0; i < students.size(); i++) {
                writer.write(String.valueOf(students.get(i).getName()
                        + COMMA
                        + students.get(i).getEmail()
                        + COMMA
                        + students.get(i).getAge()
                        + COMMA
                        + students.get(i).getStudentNumber()
                        + COMMA
                        + students.get(i).getDegree()
                        + COMMA
                        + students.get(i).getGPA()));
                writer.write(ESCAPE_CHAR);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importStudents () {
        lock.lock();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("student-details.txt"));
            String line = "";
            String [] lines = {};
            while ((line = reader.readLine()) != null) {
                lines = line.split(",");
                students.add(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), lines[4]));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    //The method will check for any integer values in the string.
    public boolean checkInteger (String name) {
        boolean result = false;
        char [] args = name.toCharArray();

        for (char elements: args) {
            if (Character.isDigit(elements)) {
                return true;
            }
        }
        return result;
    }
}
