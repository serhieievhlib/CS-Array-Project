import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        int[] myarray = new int[150]; //Declaired Variables for functions
        int actsize = 0;
        int targetnum = 0;
        int indxoldvalue = 0;
        int newvalue = 0;
        int indremove = 0;
        int choice = 0;
        boolean sucsessmodnum = modifynum(myarray,indxoldvalue ,newvalue );
        boolean addatend = addinend(myarray,newvalue,actsize);
        boolean remove = removenum(myarray,indremove,actsize);
        try{
            File myFile = new File("A1input.txt");      //reading file values into myarray
            Scanner fileScanner= new Scanner(myFile);

            while (fileScanner.hasNext() && actsize < 150) {    //with every number increasing actual size variable to keep track or size
                myarray[actsize] = fileScanner.nextInt();
                actsize ++;
            }
            fileScanner.close();
           System.out.println("File has been loaded it has "+ actsize + " integers. ");
        }
        catch(FileNotFoundException e){
            System.out.println("file has not been found.");

        }

        //for(int i = 0;i<actsize;i++){
          //  System.out.print(myarray[i] + " ");
          //}
        System.out.println("Hello choose which operation you would like to do."); //main menu for user
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
        Scanner myscanner = new Scanner(System.in);
        choice = myscanner.nextInt();
        if(choice==0){
            System.out.println("Exiting program. Goodbye!"); // if user press 0 it will exit program
            System.exit(0);
        }
        while(choice>5 || choice<1 ){
            System.out.println("Provide valid choice 1-5.\n"); // block in case user enters wrong value to choose function
            choice = myscanner.nextInt();
            if(choice==0) {
                System.out.println("Exiting program. Goodbye!");
            }
        }
        while(choice>=1 || choice<= 5) {   // main menu block where functions called
            if(choice==0){
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
            }
            if (choice == 1) {  //first option where user want to find number having an index
                int result;
                System.out.println("You choose to find number.\nProvide a number you would like to find from 0 to a 100.");
                targetnum = myscanner.nextInt(); //storing user input
                result = findnumber(myarray, actsize, targetnum); //calling functions with provided values
                System.out.println("The index of number you looking for is " + result + ".\n");
                //System.out.println("Actsize "+actsize);
                System.out.println("1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
                choice = myscanner.nextInt();
            }
            //System.out.println("\n"+ targetnum);
            else if (choice == 2) {     //second option to modify number having index it will return old and new value
                int result;
                int oldv;
                System.out.println("You choose to modify number.\nPlease provide index of old value.\n");
                indxoldvalue = myscanner.nextInt();
                while (indxoldvalue < 0 || indxoldvalue > actsize - 1) { //check if index valid
                    System.out.println("Please enter index from 0 to " + (actsize - 1));
                    indxoldvalue = myscanner.nextInt();
                }
                System.out.println("Please provide new value. \n");
                newvalue = myscanner.nextInt(); //user provides new value
                oldv = myarray[indxoldvalue];   //storing old value to provide it to user after chaneg
                modifynum(myarray, indxoldvalue, newvalue); //calling function and providing values
                System.out.println("Your old value " + oldv + " your new value is " + newvalue + " .");
                System.out.println("1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
                choice = myscanner.nextInt();//back to menu
                //System.out.println(myarray[99]);
            } else if (choice == 3) { //add number to the end of array
                System.out.println("You chose to add new value at the end.\nPlease provide an value you would like to add.");
                newvalue = myscanner.nextInt(); //storing user value
                addinend(myarray,newvalue,actsize); //calling function with values provided
                System.out.println("The last element at array is "+ myarray[actsize]);
                actsize++; //incrementing avtual size
                System.out.println("Actsize "+actsize);
                System.out.println("1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
                choice = myscanner.nextInt();

            } else if (choice==4) {
                System.out.println("Provide index you would like to remove..."); //option to remove number from array
                indremove = myscanner.nextInt(); //storing values from user
                removenum(myarray,indremove,actsize);//calling function with provided functions
                if(remove==true) {
                    System.out.println("Number was remover!");
                }
                actsize--;//decrement size
                //System.out.println("Actsize "+actsize);
                System.out.println("1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
                choice = myscanner.nextInt();
            } else if (choice==5 ) {
                for (int i = 0;i<actsize;i++){
                    System.out.print(myarray[i]+ " ");
                }
                System.out.println("\n1: Find | 2: Modify | 3: Add | 4: Remove | 5: Print | 0: Exit");
                choice = myscanner.nextInt();

            }

        }
    }






    public static int findnumber(int[] myarray, int actsize , int targetnum ){//first function to find number
        try {
                for (int i = 0; i < actsize; i++) {//user provided number we looking throught array and if it number user provided we return it
                    if (targetnum == myarray[i]) {
                        return i;
                    }
                }
        }
        catch (Exception e) {
            System.out.println("Something went wrong.");
            return -1;//in case if block didnt find anything it will return -1 as result of nothing found
        }
        return -1;
    }
    public static boolean modifynum(int[] myarray, int indxoldvalue , int newvalue ){//second function to modify number
        try{
                myarray[indxoldvalue] = newvalue; //user provided index and we making this index new value that user provied
            } catch (Exception e){
                System.out.println("Something went wrong");
                return false;
            }
        return true;
    }

    public static boolean addinend(int[] myarray,int newvalue,int actsize ){//third function to add in end of function
        try{
            if (actsize<150) { //checking if actual size extends 150
                myarray[actsize] = newvalue;//setting new vlue in end of actual size of array
            }
            return true;
        }
        catch(Exception e){
            System.out.println(" Something went wrong. ");
            return false;
        }
    }
    public static boolean removenum(int[] myarray, int indremove, int actsize){//fourth function to remove number at given index
        try{
            if(indremove<actsize) {//check if index to remove smaller then actual size
                for (int i = indremove; i < actsize - 1; i++) {
                    myarray[i] = myarray[i + 1];

                }
            }
            return true;
        }
        catch(Exception e){
            System.out.println(" Something went wrong!");
            return false;
        }

    }

}
