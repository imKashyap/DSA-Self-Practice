package practice.oops;

import java.io.IOException;
import java.util.*;

public class MyClass2 {
    public static void main(String[] args) throws IOException {
        EduProgram[] programs = new EduProgram[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            boolean d = sc.nextBoolean();
            boolean e = sc.nextBoolean();
            sc.nextLine();
            programs[i] = new EduProgram(a, b, c, d, e);
        }
        String sponsor = sc.nextLine();
        String ans = findEduProgramClassification(programs);
        if(ans==null)
        System.out.println("EduPrograms are not available now");
        else System.out.println(ans);
        EduProgram[] arr = findEduProgramBySponsor(programs, sponsor);
        if (arr == null)
            System.out.println("No EduProgram is available for the given sponsor");
        else {
            for (EduProgram eduProgram : arr) {
                System.out.println(eduProgram.getEduProgramName());
                System.out.println(eduProgram.getNoOfPeopleAttended());
            }
        }
    }

    public static String findEduProgramClassification(EduProgram[] eduPrograms) {
        for (EduProgram current : eduPrograms) {
            if (current.getStillAvailable() && current.getWithinCountry()) {
                if (current.getNoOfPeopleAttended() >= 1000) return "EverGreen";
                else if (current.getNoOfPeopleAttended() >= 500) return "Golden";
                else return "Emerging Star";
            }
        }
        return null;
    }

    public static EduProgram[] findEduProgramBySponsor(EduProgram[] eduPrograms, String sponsor) {
        List<Integer> people = new ArrayList<>();
        Map<Integer, EduProgram> selected = new HashMap<>();
        for (EduProgram eduProgram : eduPrograms) {
            if ((eduProgram.getSponsor()).equalsIgnoreCase(sponsor)) {
                people.add(eduProgram.getNoOfPeopleAttended());
                selected.put(eduProgram.getNoOfPeopleAttended(), eduProgram);
            }
        }
        if (people.size() == 0)
            return null;
        else {
            Collections.sort(people);
            List<EduProgram> programList = new ArrayList<>();
            for (Integer person : people) {
                programList.add(selected.get(person));
            }
            EduProgram[] programs = new EduProgram[programList.size()];
            programList.toArray(programs);
            return programs;
        }
    }
}
