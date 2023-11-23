package model;

import java.io.File;
import java.util.*;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * Defines the Classes.
 **/
public class Vakken {

    Map<String, Integer> vakken = new HashMap<>();

    public Vakken() {
    }

    public boolean containsVak(String vakName) {
        return vakken.containsKey(vakName);
    }

    public List<Integer> getAllECTPoints() {
        return new ArrayList<>(vakken.values());
    }

    public List<String> getAllVakken() {
        List<String> allVakken = new ArrayList<>(vakken.keySet());
        Collections.sort(allVakken);
        return allVakken;
    }

    public String[] getAllVakkenMetEct() {
        Set<String> allKeyValuePairsMap = vakken.keySet();
        String[] allKeyValuePairsArray = allKeyValuePairsMap.toArray(new String[0]);
        Arrays.sort(allKeyValuePairsArray);
        for (int index = 0; index < allKeyValuePairsArray.length; index++) {
            allKeyValuePairsArray[index] += ": " + vakken.get(allKeyValuePairsArray[index]);
        }

        return allKeyValuePairsArray;
    }

    public int getOneVak(String vakName) {
        return vakken.get(vakName);
    }

    public List<Map.Entry<String, Integer>> printKeyValuePairs() {
        return new ArrayList<>(vakken.entrySet());
    }

    public void readFile(String fileName) {
        File sourceFile = new File(fileName);
        try (Scanner fileReader = new Scanner(sourceFile)) {
            while (fileReader.hasNextLine()) {
                String[] vak = fileReader.nextLine().split(" ");
                vakken.put(vak[0], Integer.parseInt(vak[1]));
            }
        } catch (Exception e) {
            System.err.println("Could not open file: " + e.getMessage());
        }
    }

    public int sumOfAllEctPoints() {
        int sum = 0;
        for (int points : getAllECTPoints()) {
            sum += points;
        }
        return sum;
    }


}
