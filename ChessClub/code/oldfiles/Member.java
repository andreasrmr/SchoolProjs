package chairmanManagement;

import static chessSystem.InputHandler.*;
import static chessSystem.Configurations.recieveIntNextMemberNumber;

public class Member{
    private int memberNumber;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String gender;
    private int cpr;
    private int phoneNumber;
    private String email;
    private String dateOfCreation;
    private boolean paymentStatus = false;
    private String typeOfMembership;

    //Create member.
    public Member(){
        this.memberNumber = recieveIntNextMemberNumber();
        System.out.print("FirstName: ");
        this.firstName = readString();
        System.out.print("LateName: ");
        this.lastName = readString();
        System.out.print("BirthDate (dd/mm/yyyy): ");
        this.birthDay = readString();
        System.out.print("Gender: ");
        this.gender = readString();
        System.out.print("CPR: ");
        this.cpr = readInt();
        System.out.print("PhoneNumber (xxxxxxxx): ");
        this.phoneNumber = readInt();
        System.out.print("Email: ");
        this.email = readString();
        System.out.print("Date Of Creation (dd/mm/yyyy): ");
        this.dateOfCreation = readString();
        this.paymentStatus = false;
        System.out.print("Type of membership: ");
        this.typeOfMembership = readString();
    }
    //Change members.
    public Member(String member){
        String[] lineItems = member.split(";");
        this.memberNumber = Integer.parseInt(lineItems[0]);
        this.firstName = lineItems[1];
        this.lastName = lineItems[2];
        this.birthDay = lineItems[3];
        this.gender = lineItems[4];
        this.cpr = Integer.parseInt(lineItems[5]);
        this.phoneNumber = Integer.parseInt(lineItems[6]);
        this.email = lineItems[7];
        this.dateOfCreation = lineItems[8];
        this.paymentStatus = Boolean.parseBoolean(lineItems[9]);
        this.typeOfMembership = lineItems[10];
    }
    //Simply setters.
    public void setMemberNumber(int memberNumber){
        this.memberNumber = memberNumber;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setBirthDay(String birthDay){
        this.birthDay = birthDay;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setCpr(int cpr){
        this.cpr = cpr;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDateOfCreation(String dateOfCreation){
        this.dateOfCreation = dateOfCreation;
    }
    public void setTypeOfMembership(String typeOfMembership){
        this.typeOfMembership = typeOfMembership;
    }
    public String toString(){
        return this.memberNumber + ";" + this.firstName + ";" + this.lastName + ";" + this.birthDay + ";" + this.gender + ";" + this.cpr + ";" + this.phoneNumber + ";" + this.email + ";" + this.dateOfCreation + ";" + this.paymentStatus + ";" + this.typeOfMembership;
    }
    //public void equals(int memberNumber, int cpr, File file){}

}

