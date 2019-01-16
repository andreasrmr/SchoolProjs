package chairmanManagement;

import java.time.LocalDate;
import java.time.Period;

import static chessSystem.Configurations.*;
import static chessSystem.FileHandler.readLine;
import static chessSystem.InputHandler.*;
import static chessSystem.InputVerification.*;
import static chessSystem.FileHandler.getLineNumOfValue;

public class Member{
    private int memberNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String gender;
    private String cpr;
    private String phoneNumber;
    private String email;
    private String dateOfCreation;
    private boolean paymentStatus;
    private String typeOfMembership;

    //Create member.
    public Member(){

        setFirstName();
        setLastName();
        setBirthDay();
        //cpr depends on birthday.
        setCpr();
        //gender depends on cpr.
        setGender();
        setPhoneNumber();
        setEmail();
        setDateOfCreation();
        this.paymentStatus = false;
        setTypeOfMembership();
        this.memberNumber = recieveIntNextMemberNumber();
    }
    //Change members. 
    public Member(String member){
        String[] lineItems = member.split(";");
        this.memberNumber = Integer.parseInt(lineItems[0]);
        this.firstName = lineItems[1];
        this.lastName = lineItems[2];

        //set birthday
        this.birthDay = birthdayAsLocalDate(lineItems[3]);

        this.gender = lineItems[4];
        this.cpr = lineItems[5];
        this.phoneNumber = lineItems[6];
        this.email = lineItems[7];
        this.dateOfCreation = lineItems[8];
        this.paymentStatus = Boolean.parseBoolean(lineItems[9]);
        this.typeOfMembership = lineItems[10];
    }
    public void setFirstName(){

        do{
            System.out.print("FirstName (Only letters): ");
            this.firstName = readString();
        }while(!(regexString(Patterns.LETTERS, firstName)));
    }
    public void setLastName(){

        do{
            System.out.print("LastName (Only letters): ");
            this.lastName = readString();
        }while(!(regexString(Patterns.LETTERS, lastName)));
    }
    public void setBirthDay(){
        String bd = "";
        String str = "";
        do{
            System.out.print("BirthDate (ddmmyyyy): ");
            bd = readString();
        }while(!(validateDate(bd)));
        int day = Integer.parseInt(bd.substring(0,2));
        int month = Integer.parseInt(bd.substring(2,4));
        int year = Integer.parseInt(bd.substring(4,8));
        this.birthDay = LocalDate.of(year, month, day);
    }
    public void setCpr(){
        //depends on birthday
        do {
            System.out.print("Enter Last 4 digits in CPR (xxxx):");
            this.cpr = readString();
        }while(!(regexString(Patterns.CPRLASTFOUR, cpr)));
        //ddmmyyyy
        String tempStr = birthdayAsStr(birthDay).replaceAll("/", "");
        //ddmmyyxxxx
        this.cpr = tempStr.substring(0,4) + tempStr.substring(6, 8) + cpr;

        //give user a warning if theres a duplicate CPR number..
        int checkNum = getLineNumOfValue(recieveFileMemberDatabase(), 5, cpr);
        if(checkNum != -1){
           System.out.println("Error: CPR Duplicate with member:\n" + readLine(recieveFileMemberDatabase(), checkNum));
        }
    }
    private void setGender(){
        //depends on cpr
        if(this.cpr.charAt(9) % 2 == 0){
            this.gender = "Female";
        }
        else {
            this.gender = "Male";
        }
    }

    public void setPhoneNumber(){
        do{
            System.out.print("PhoneNumber (xxxxxxxx): ");
            this.phoneNumber = readString();
        }while (!(regexString(Patterns.PHONENUMBER, phoneNumber)));

    }
    public void setEmail(){
            System.out.print("Email: ");
            this.email = readString();
    }
    public void setDateOfCreation(){
        //dato sættes efter klokslet lokalt på maskine
        //localdate kommer i "yyyy-mm-dd"
        LocalDate localDate = LocalDate.now();

        //split date på "-"
        String[] dateSplit = localDate.toString().split("-");

        //format date til. dd-mm-yyyy
        String date = dateSplit[2] + "/" + dateSplit[1] + "/" + dateSplit[0];

        this.dateOfCreation = date;
    }
    //mangler:
    //Denne metode opdatere ikke sig selv når et medlem bliver ældre.
    //Bør eventuelt køres én gang hver måned?
    public void setTypeOfMembership(){
        LocalDate today = LocalDate.now();
        int age = Period.between(birthDay, today).getYears();
        if(age < 18){
            this.typeOfMembership = "JUNIOR";
        }
        else if(age < 60){
            this.typeOfMembership = "SENIOR";
        }
        else {
            this.typeOfMembership = "SENIORPLUS";
        }
    }
    public String toString(){
        return this.memberNumber + ";" + this.firstName + ";" + this.lastName + ";" + birthdayAsStr(birthDay) + ";" + this.gender + ";" + this.cpr + ";" + this.phoneNumber + ";" + this.email + ";" + this.dateOfCreation + ";" + this.paymentStatus + ";" + this.typeOfMembership;
    }
    //public void equals(int memberNumber, int cpr, File file){}

    public String birthdayAsStr(LocalDate bday){
        String birthdayAsStr = bday.toString();
        birthdayAsStr = birthdayAsStr.substring(8,10) + "/" + birthdayAsStr.substring(5,7) + "/" + birthdayAsStr.substring(0,4);
        return birthdayAsStr;
    }
    public LocalDate birthdayAsLocalDate(String bday){
        int day = Integer.parseInt(bday.substring(0,2));
        int month = Integer.parseInt(bday.substring(3,5));
        int year = Integer.parseInt(bday.substring(6,10));
        LocalDate birthDay = LocalDate.of(year, month, day);
        return birthDay;
    }
}

