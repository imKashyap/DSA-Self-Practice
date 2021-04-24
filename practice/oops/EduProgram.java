package practice.oops;

public class EduProgram {
    private String eduProgramName;
    private String sponsor;
    private int noOfPeopleAttended;
    private boolean stillAvailable;
    private boolean withinCountry;

    EduProgram( String eduProgramName,String sponsor,
                int noOfPeopleAttended, boolean stillAvailable,
                boolean withinCountry){
        this.eduProgramName=eduProgramName;
        this.sponsor=sponsor;
        this.noOfPeopleAttended=noOfPeopleAttended;
        this.stillAvailable=stillAvailable;
        this.withinCountry=withinCountry;
    }

    String getEduProgramName (){
        return this.eduProgramName;
    }

    String getSponsor (){
        return this.sponsor;
    }

    int getNoOfPeopleAttended (){
        return this.noOfPeopleAttended;
    }
    boolean getStillAvailable (){
        return this.stillAvailable;
    }
    boolean getWithinCountry (){
        return this.withinCountry;
    }

}
