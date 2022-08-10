import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AssessmentTwo {
    public static void main(String[] args) throws IOException {
        /*
        //This section of the codes is commented out as per the requirement of the assessment.

        AssessmentTwo oop = new AssessmentTwo();
        oop.partOne();
        oop.partTwo();
        oop.partThree();
        oop.partFour();
        oop.partFive();
        oop.partSix();*/

    }

    public void partOne () {
        //First Unit object
        Unit programmingII = new Unit("programming II", "2008");

        //five different student objects
        Student Nima = new Student("Nima Phuntsho", "nimafunso@gmail.com", 24, 84999322, "BIT");
        Student Rashford = new Student("Marcus Rashford", "rashy@gmail.com", 21, 34511245, "MIT");
        Student Sancho = new Student("Jadon Sancho", "jacho@yahoo.com", 19, 34517788, "MBA");
        Student Martial = new Student("Anthony Martial", "amartial@gmail.com", 32, 34674423, "BSc Computer");
        Student Bruno = new Student("Bruno Fernandez", "bruno@infotech.scu.au", 29, 81903222, "BBA");

        //Adding the students to the list (students);
        programmingII.addStudent(Nima);
        programmingII.addStudent(Rashford);
        programmingII.addStudent(Sancho);
        programmingII.addStudent(Martial);
        programmingII.addStudent(Bruno);

        //removing a student from the list.
        programmingII.removeStudent(Bruno);

        //calling the method to get the total number of students enrolled in a unit.
        System.out.println("Total number of Students : " + programmingII.numberOfStudents() + "\n");

        //Calling a method to print the student details
        programmingII.printStudents();
    }

    public void partTwo (){
        //Second Unit object.
        Unit database = new Unit("Database", "2001");

        //Another five new student objects.
        Student Rooney = new Student("Van der Sar", "wraooney@gmail.com", 45, 40603674, "BIT");
        Student Van = new Student("Van der Sar", "rvdr@gmail.com", 39, 32571192, "MIT");
        Student Eric = new Student("Eric Cantona", "eric@yahoo.com", 56, 56791044, "MBA");
        Student Fred = new Student("Luiz Fred", "fred@gmail.com", 27, 45813069, "BSc Computer");
        Student Varane = new Student("Raphael Varane", "varane@infotech.scu.au", 32, 51702618, "BBA");

        //Adding the above students to the list.
        database.addStudent(Rooney);
        database.addStudent(Van);
        database.addStudent(Eric);
        database.addStudent(Fred);
        database.addStudent(Varane);

        //Printing the students details before sorting
        System.out.println("**** BEFORE SORTING ****");
        database.printStudents();
        System.out.println("**** AFTER SORTING ****");

        //Calling sort student method defined in unit class to sort the list.
        database.sortStudents();
        database.printStudents();
    }

    public void partThree () {
        //Third Unit Object.
        Unit cyberSecurity = new Unit("Database", "2001");

        //New staff objects
        Staff tenHag = new Staff("Ten Hag", "ten@gmail.com", 66, "Gold Coast");
        Staff Harry = new Staff("Harry Maguire", "harry@gmail.com", 45, "Lismore");
        Staff Martinez = new Staff("Latuto Martinez", "martine@gmail.com", 37, "Sydney");
        Staff Mark = new Staff("Mark Goldbridge", "mark@gmail.com", 41, "Manchester");
        Staff Robbie = new Staff("Robbie Lyle", "robbie@gmail.com", 51, "North London");

        //Adding the staffs into the hashmap by calling the addStaff method.
        cyberSecurity.addStaff("Unit accessor", tenHag);
        cyberSecurity.addStaff("Lecturer", Harry);
        cyberSecurity.addStaff("TutorOne", Martinez);
        cyberSecurity.addStaff("TutorTwo", Mark);
        cyberSecurity.addStaff("TutorThree", Robbie);

        cyberSecurity.removeStaff("TutorTwo", Mark);

        //Printing the staff details.
        cyberSecurity.printStaff();
    }

    public void partFour () {
        /*
        * Student object with a VALID input setter value.
        * example :
        * name      - it must not contain integer values.
        * email     - it must have @ symbol
        * studentID - it must have 8 digit value
        * age       - age cannot be less than 0.
        *
        * If the arguments doesn't meet the above requirements, it will throw an Illegal Argument Exception which can be
        * seen on the second object.
        *
        * < OTHER EXCEPTIONS>
        * There is a null pointer exception in Unit class (numberOfStudent method) where it will throw an exception if
        * linked list is empty. Also, the printStaff method has a null pointer exception in the unit class as the method
        * checks the hashmap first to make sure the collection is not empty.
        *
        * */
        Student David = new Student("David Bentley", "betley@gmail.com", 13, 26917056, "MIT");

        //Student object have a INVALID input (age)  setter value, this will throw an illegal argument exception with message.
        Student Rooney = new Student("Wanye Rooney", "wraooney@gmail.com", -1, 19609656, "BIT");
    }

    public void partFive () {
        //New Unit object
        Unit networking = new Unit("Data and Networking", "1005");

        //Five new student objects
        Student steve = new Student("Steven Gerrad", "steve@gmail.com", 17, 45910676, "BIT");
        Student Gomez = new Student("Angel Gomez", "angel@gmail.com", 34, 56661835, "MIT");
        Student Greenwood = new Student("Mason Greenwood", "maze@yahoo.com", 18, 34151441, "MBA");
        Student Chong = new Student("Patrick Chong", "pat@gmail.com", 25, 53715448, "BSc Computer");
        Student Phil = new Student("Phil Jones", "jones@infotech.scu.au", 32, 34742722, "BBA");

        //Adding the above student objects to the list (students linkedList).
        networking.addStudent(steve);
        networking.addStudent(Gomez);
        networking.addStudent(Greenwood);
        networking.addStudent(Chong);
        networking.addStudent(Phil);

        //calling the exportStudents method to write all the student details into a file (student-details.txt).
        networking.exportStudents();
    }

    public void partSix () {
        //New unit object
        Unit systemsAnalysis = new Unit("System Analysis", "3001");

        //calling the importStudents method.
        systemsAnalysis.importStudents();

        //Print the total number of students onto the console
        System.out.println("Total number of students (Systems Analysis Unit): " + systemsAnalysis.numberOfStudents());

        //prints all the details of the students
        systemsAnalysis.printStudents();
    }
}