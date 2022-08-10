import java.util.Comparator;

public class SortStudents implements Comparator <Student> {

    /*
    * The method will sort the student list using two instance variables (name and student ID) in a natural order.
    * First the student name is used to sort the list and if the student have same (equal) name, the list will be sorted
    * using the student number.
    *
    * */
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().equals(o2.getName())) {
            if (o1.getStudentNumber() < o2.getStudentNumber()) {
                return -1;
            } else if (o1.getStudentNumber() > o2.getStudentNumber()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}