package test.floor.plan.flooplan;

import java.io.IOException;
import java.util.Scanner;
import test.floor.plan.flooplan.util.FileReaderConsole;
import test.floor.plan.flooplan.util.FloorPlan;
import test.floor.plan.flooplan.util.ParseData;

public class ConsoleMain {

    public static void main(String[] args) throws IOException {
        ParseData parseData = new ParseData();
        FloorPlan floorPlan = new FloorPlan();
        FileReaderConsole fileReaderConsole = new FileReaderConsole();

        Scanner scanner = new Scanner(System.in);
        String string;
        do {
            System.out.println("please enter coordinate like 1,1;1,2;2,2;2,1");
            System.out.println("each pair coordinate should be more than 3");
            System.out.println("if you entered more than 2 element next element will be ignored");
            System.out.println("like this 1,2,3 - 3 will be ignored");
            System.out.println("if you want left console enter: exit");
            System.out.println("if you want read from file enter -f /path/to/file");
            string = scanner.nextLine();
            String[] arrayString = string.split(" ");
            if (arrayString.length == 1) {
                if (!arrayString[0].equals("exit")) {
                    if (floorPlan.floorChecker(parseData.parse(string))) {
                        System.out.println("legal");
                    } else {
                        System.out.println("illegal");
                    }
                }
            } else {
                for (String s : fileReaderConsole.getStringFromFile(arrayString[1])) {
                    if (floorPlan.floorChecker(parseData.parse(s))) {
                        System.out.println("legal");
                    } else {
                        System.out.println("illegal");
                    }
                }
            }
        } while (!string.equals("exit"));
    }
}
