package model;

import java.io.File;
import java.util.*;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * Defines and handles everything about the student.
 **/
public class StudentResult {
    Map<Integer, List<String>> studenten = new HashMap<>();

    public StudentResult() {
    }

    public void readFile(String fileName) {
        File sourceFile = new File(fileName);
        try (Scanner fileReader = new Scanner(sourceFile)) {
            while (fileReader.hasNextLine()) {
                int student = fileReader.nextInt();
                List<String> studentVakCodes = new ArrayList<>();
                String vakCode = fileReader.next();
                studentVakCodes.add(vakCode);
                if (!studenten.containsKey(student)) {
                    studenten.put(student, studentVakCodes);
                } else {
                    studenten.get(student).add(vakCode);
                }
            }
        } catch (Exception e) {
            System.err.println("Could not open file: " + e.getMessage());
        }
    }

    public List<String> getAllStudentsWithVakken() {
        List<String> allStudentsWithVakken = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> student : studenten.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nStudent: ").append(student.getKey()).append(" is following those courses:\n");
            for (String vakToAdd : student.getValue()) {
                stringBuilder.append(vakToAdd).append(", ");
            }
            allStudentsWithVakken.add(stringBuilder.toString());
        }
        return allStudentsWithVakken;
    }

    public List<String> getAllStudentsWithEctPoints(Vakken vakken) {
        List<String> studentWithPoints = new ArrayList<>();
        for (Integer student : studenten.keySet()) {
            StringBuilder stringBuilder = new StringBuilder("Student: ");
            stringBuilder.append(student).append(" has ");
            int points = 0;
            for (String vak : studenten.get(student)) {
                points += vakken.getOneVak(vak);
            }
            stringBuilder.append(points).append(" points");
            studentWithPoints.add(stringBuilder.toString());
        }
        return studentWithPoints;
    }

    public String getOneStudentDetail(int studentNr, Vakken vakken) {
        List<String> vakkenOfStudent = studenten.get(studentNr);
        Collections.sort(vakkenOfStudent);
        String followedCourses = vakkenString(vakkenOfStudent);
        int studentenPunten = 0;
        for (String vakName : vakkenOfStudent) {
            studentenPunten += vakken.getOneVak(vakName);
        }
        StringBuilder student = new StringBuilder();
        student.append("\nStudent ").append(studentNr).append(" has ").append(studentenPunten).append(" points.");
        student.append("\nHe followed the courses:\n").append(followedCourses);
        return student.toString();
    }

    public List<String> getAllStudentDetail(Vakken vakken) {
        List<String> studentenDetail = new ArrayList<>();
        for (Integer student : studenten.keySet()) {
            studentenDetail.add(getOneStudentDetail(student, vakken));
        }
        return studentenDetail;
    }

    private static String vakkenString(List<String> vakkenOfStudent) {
        StringBuilder followedCourses = new StringBuilder();
        for (String string : vakkenOfStudent) {
            followedCourses.append(string).append(", ");
        }
        return followedCourses.toString();
    }

}
