import java.time.LocalDate;
import java.util.*;
import java.io.*;

//DONE
class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public Double Duration;
    public String Description;
    

    public StudyLog(LocalDate A,String B, Double C, String D)
    {
        this.Date= A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}

class StudyTracker
{
    //Datastructer to hold the data abiut study

    private ArrayList <StudyLog> Database = new ArrayList <StudyLog> ();

    public void InsertLog()
    {

        Scanner ScannerObj = new Scanner(System.in);

        System.out.println("=========================================================================================");
        System.out.println("|| ============== Please Enter the Valid Details Of Your Study ======================= ||");
        System.out.println("=========================================================================================");

        LocalDate DateObj = LocalDate.now();

        System.out.println("Please Provide The Name Of The Subject like C/C++/Java/OS/DS :");
        String sub = ScannerObj.nextLine();

        System.out.println("Enter The Time Period of Your Study in Hours :");
        double dur = ScannerObj.nextDouble(); 
        ScannerObj.nextLine();

        System.out.println("Please Provide The Description About the Study For Future Reference :");
        String desc = ScannerObj.nextLine();

        StudyLog StudyObj = new StudyLog(DateObj, sub, dur, desc);

        Database.add(StudyObj);

        System.out.println("Study Log Gets Stored Successfully");
        System.out.println("=========================================================================================");

    }

    public void DisplayLog()
    {
        System.out.println("=========================================================================================");

        if(Database.isEmpty())
        {
            System.out.println("NOTHING TO DISPLAY AS DATABASE IS EMPTY");
            System.out.println("=========================================================================================");
            return;
        }

        System.out.println("=========================================================================================");
        System.out.println("|| ================LOG REPORT FROM STUDY TRACKER============================||");
        System.out.println("=========================================================================================");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }
        System.out.println("=========================================================================================");


    }

    public void ExportCSV()
    
    {
        if(Database.isEmpty())
        {
            System.out.println("=========================================================================================");
            System.out.println("||===================NOTHING TO DISPLAY AS DATABASE IS EMPTY===========================||");
            System.out.println("=========================================================================================");
            return;
        }

        String Filename = "Study.csv";

       try(FileWriter fwobj = new FileWriter(Filename))
       {
            //write CSV header
            fwobj.write("Date,Subject,Duration,Description\n");

            //travel databse
             for(StudyLog sobj : Database)
            {
                //write each record in csv
                            fwobj.write(sobj.getDate() +","+
                            sobj.getSubject().replace(","," ")+","+
                            sobj.getDuration()+","+
                            sobj.getDescription().replace(","," ")+"\n"
                );
            }

            System.out.println("LOG CREATED SUCCESSFULLY!");


       }
       catch(Exception eobj)
       {
        System.out.println("Exception Occured While Creating the CSV File.");
        System.out.println("Report this issue to Author Parag.");
       }
    }

    public void SummaryByDate()
    {
        System.out.println("=========================================================================================");

        if(Database.isEmpty())
        {
            System.out.println("NOTHING TO DISPLAY AS DATABASE IS EMPTY!!!");
            System.out.println("=========================================================================================");
            return;
        }

        System.out.println("=========================================================================================");
        System.out.println("||=================SUMMARY BY DATE FROM STUDY TRACKER=======================||");
        System.out.println("=========================================================================================");

        TreeMap  <LocalDate,Double>tobj = new TreeMap<LocalDate,Double>();

        LocalDate lobj = null;
        double d,old;

        for(StudyLog sobj : Database)
        {
            lobj=sobj.getDate();
            d= sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old =tobj.get(lobj);
                tobj.put(lobj,d + old);
            }
            else
            {
                tobj.put(lobj,d);
            }
            
            
        }
        //Display the details as per date

        for(LocalDate ldbj : tobj.keySet())
        {
            {
                System.out.println("Date : " + ldbj +
                                " || Total Study : " +
                                tobj.get(ldbj) + " Hours");
            }
        }
        System.out.println("=========================================================================================");



    }

    public void SummaryBySubject()
    {
        System.out.println("=========================================================================================");

        if(Database.isEmpty())
        {
            System.out.println("NOTHING TO DISPLAY AS DATABASE IS EMPTY!!!");
            System.out.println("=========================================================================================");
            return;
        }

        System.out.println("=========================================================================================");
        System.out.println("||=================SUMMARY BY SUBJECT FROM STUDY TRACKER=======================||");
        System.out.println("=========================================================================================");

        TreeMap  <String,Double>tobj = new TreeMap<String,Double>();

        double d,old;
        
        String s;

        for(StudyLog sobj : Database)
        {
            s= sobj.getSubject();
            d= sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old =tobj.get(s);
                tobj.put(s,d + old);
            }
            else
            {
                tobj.put(s,d);
            }
            
            
        }
        //Display the details as per subject

        for(String str : tobj.keySet())
        {
            System.out.println("Subject :"+str+" || Total Study "+tobj.get(str));
        }
        System.out.println("=========================================================================================");



    }


}

class StudyTrackerApp           //StudyTrackerStarter
{
    public static void main(String[] args) 
    {
        // FIX 1: Reference type changed from StudyTrackerApp to StudyTracker
        StudyTracker stobj = new StudyTracker();
        Scanner ScannerObj = new Scanner(System.in);

        int iChoice = 0;

        System.out.println("=========================================================================================");
        System.out.println("============WELCOME TO STUDY TRACKER APPLICATION==============================");
        System.out.println("=========================================================================================");

        do {

            System.out.println("=====================PLEASE SELECT THE APPROPRIATE OPTION ========================");
            System.out.println("1 : Insert New Study Log Into Database ");
            System.out.println("2 : View All Study Logs ");
            System.out.println("3 : Summary Of Study Log By Date");
            System.out.println("4 : Summary Of Study Log By Subject");
            System.out.println("5 : Export Study Log To CSV File");
            System.out.println("6 : Exit the Application");

            iChoice = ScannerObj.nextInt();

            switch (iChoice) {
                case 1:           //Insert New Study Log Into Database

                    stobj.InsertLog();
                    
                    break;
                    
                case 2:           //View All Study Logs

                    stobj.DisplayLog();
                    
                    break;
                
                case 3:           //Summary Of Study Log By Date

                    stobj.SummaryByDate();

                    
                    break;
                
                case 4:           //Summary Of Study Log By Subject
                    stobj.SummaryBySubject();
                    break;
                
                case 5:            //Export Study Log To CSV File

                    stobj.ExportCSV();
                    
                    break;
                
                case 6:             //exit
                
                    System.out.println("=========================================================================================");
                    System.out.println("============THANKS FOR USING STUDY TRACKER APPLICATION========================");
                    System.out.println("=========================================================================================");
                        
                    break;
            
                default:
                System.out.println("INVALID OPERATION");
                    break;
            }
            
        }while (iChoice != 6);
 
        // FIX 2: Close the scanner to prevent memory leaks
        ScannerObj.close();
    }
}