package controller;

import model.StudentResult;
import model.Vakken;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * Launches the program.
 **/
public class HashMapLauncher {
    public static void main(String[] args) {
        Vakken vakken = new Vakken();
        StudentResult studentResult = new StudentResult();

        String vakFilePath = "src/main/resources/vakcodes.txt";
        String studentFilePath = "src/main/resources/studentresults.txt";
        vakken.readFile(vakFilePath);
        studentResult.readFile(studentFilePath);

        for (String student : studentResult.getAllStudentsWithVakken()) {
            System.out.println(student);
        }

        for (String studentWithPoints : studentResult.getAllStudentsWithEctPoints(vakken)) {
            System.out.println(studentWithPoints);
        }
        System.out.println();
        System.out.println("Get All students detail:");
        for (String string : studentResult.getAllStudentDetail(vakken)) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("Get one Student detail:");
        System.out.println(studentResult.getOneStudentDetail(1006, vakken));

//        vakkenTest(vakken);
    }

    private static void vakkenTest(Vakken vakken) {
        System.out.println(vakken.getAllVakken());
        System.out.println(vakken.getAllECTPoints());
        System.out.println(vakken.sumOfAllEctPoints());
        System.out.println(vakken.printKeyValuePairs());
        for (String string : vakken.getAllVakkenMetEct()) {
            System.out.println(string);
        }
    }
}
