# Study Tracker Application

A lightweight, console-based Java tracking application designed to log daily study sessions. Features an in-memory database using `ArrayList` collections, automatic alphabetical and chronological analytics reports powered by `TreeMap`, and a robust data-sanitizing export pipeline that builds clean spreadsheet-compatible CSV metrics files effortlessly.

---

## # Table of Contents
1. [Features](#-features)
2. [Architecture & Class Design](#-architecture--class-design)
3. [Technology Stack](#-technology-stack)
4. [Installation & Setup](#-installation--setup)
5. [Usage Walkthrough](#-usage-walkthrough)
6. [Data Handling & Integrity](#-data-handling--integrity)

---

## # Features

- **Automated Data Entry:** Automatically captures the runtime timestamp using Java's `LocalDate` API alongside user inputs for subject, hours, and descriptions.
- **In-Memory Database Storage:** Tracks data updates seamlessly during execution runtime without database overhead.
- **Smart Analytics Summaries:** Groups metrics efficiently:
  - *By Date:* Sums up studying durations grouped and sorted chronologically.
  - *By Subject:* Aggregates study hours grouped and sorted alphabetically.
- **Sanitized Data Persistence:** Cleans user text on-the-fly and exports error-free, spreadsheet-ready `.csv` tables.

---

## # Architecture & Class Design

The application follows clean Object-Oriented Programming (OOP) architectures across three individual building-block classes:

1. **`StudyLog`**
   - The primary data model structure mapping out your variables: `Date`, `Subject`, `Duration`, and `Description`.
   - Utilizes explicit getter methods to practice encapsulation and overrides the `.toString()` handler for quick string output.
2. **`StudyTracker`**
   - The central processing layer of the system.
   - Manages data storage inside an internal `ArrayList` and builds map aggregations with `TreeMap`.
3. **`StudyTrackerApp`**
   - The application entry point (`main` method) controlling the interactive user console menu and choice routing via a continuous loop.

---

## # Technology Stack

- **Language:** Java (JDK 8 or higher required)
- **Collections Framework:** `ArrayList`, `TreeMap`, `Set`
- **Time API:** `java.time.LocalDate`
- **File System Streams:** `java.io.FileWriter` (leveraging modern try-with-resources constructs)
- **Input Stream Processing:** `java.util.Scanner`

---

## # Installation & Setup

Follow these exact steps to compile and run your repository locally:

### Step 1: File Initialization
Save the application source code in a file named exactly:
```bash
StudyTrackerApp.java
Step 2: Compile Bytecode
Open your terminal or command prompt inside the folder where your file is located and run the Java compiler:

Bash
javac StudyTrackerApp.java
Step 3: Run the Program
Execute the compiled application artifact utilizing the Java Virtual Machine (JVM):

Bash
java StudyTrackerApp
# Usage Walkthrough
Upon booting, the program launches into an interactive loop presenting the following capabilities:

Plaintext
=========================================================================================
============WELCOME TO STUDY TRACKER APPLICATION=========================================
=========================================================================================
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
Input Processing flow
Option 1: Prompted to type subject name (e.g. Java), duration as a decimal fraction (e.g. 2.5 hours), and detailed notes.

Option 2: Evaluates your collection entries and outputs an aligned record printout.

Option 3 / 4: Instantiates a key-value sorting matrix via TreeMap to dynamically condense overlapping rows into a single accumulated metric block.

Option 5: Instantly creates Study.csv inside your project's working path.

# Data Handling & Integrity
Delimiter Collision Defense: Raw user inputs often contain conversational commas (e.g. "Studied tables, loops, and lists"). Standard CSV parsing software splits columns on every comma, which completely ruins file alignments. This application automatically targets and updates descriptions via .replace(",", " ") to defend table spacing.

Leak Mitigation: The presentation controller handles resource lifecycles correctly by calling ScannerObj.close() at termination to free native operating system hooks.

Safe-Close Pipelines: The export code utilizes try-with-resources which automatically ensures external disk streams shut down safely, even if runtime operations fail mid-write.

## OUTPUT ##

Phase 1: Launch and Initial Data Entry (Option 1)
When you run the application, the primary menu loads. Here is the output trace of inserting multiple logs into the database:

Plaintext
=========================================================================================
============WELCOME TO MARVELLOUS STUDY TRACKER APPLICATION==============================
=========================================================================================
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
1

=========================================================================================
|| ============== Please Enter the Valid Details Of Your Study ======================= ||
=========================================================================================
Please Provide The Name Of The Subject like C/C++/Java/OS/DS :
Java
Enter The Time Period of Your Study in Hours :
3.5
Please Provide The Description About the Study For Future Reference :
Learned OOP principles, encapsulation, and classes.
Study Log Gets Stored Successfully
=========================================================================================
If you repeat this process to add a couple more entries (for example, another Java entry for 2.0 hours, and an OS entry for 4.0 hours), the application processes them silently into the temporary memory array.

Phase 2: Viewing the Raw Database Logs (Option 2)
Selecting Option 2 calls the custom toString() method built into your code to map out every active entry in sequential order:

Plaintext
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
2

=========================================================================================
=========================================================================================
|| ================LOG REPORT FROM MARVELLOUS STUDY TRACKER============================||
=========================================================================================
2026-06-08 | Java | 3.5 | Learned OOP principles, encapsulation, and classes.
2026-06-08 | Java | 2.0 | Debugged inheritance issues.
2026-06-08 | OS | 4.0 | Read about multithreading and process synchronization.
=========================================================================================
Phase 3: Displaying Calculated Summaries (Options 3 & 4)
Your code utilizes TreeMap collections to automatically sort, group, and calculate totals.

Option 3: Summary By Date
Because all logs above were entered on the same day, Option 3 seamlessly sums the values (3.5 + 2.0 + 4.0 = 9.5 hours total):

Plaintext
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
3

=========================================================================================
=========================================================================================
||=================SUMMARY BY DATE FROM MARVELLOUS STUDY TRACKER=======================||
=========================================================================================
Date : 2026-06-08 || Total Study : 9.5 Hours
=========================================================================================
Option 4: Summary By Subject
Option 4 isolates unique subject names. It groups the two independent Java sessions together (3.5 + 2.0 = 5.5) and sorts the final list alphabetically (Java before OS):

Plaintext
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
4

=========================================================================================
=========================================================================================
||=================SUMMARY BY SUBJECT FROM MARVELLOUS STUDY TRACKER=======================||
=========================================================================================
Subject :Java || Total Study 5.5
Subject :OS || Total Study 4.0
=========================================================================================
Phase 4: File Generation & Shutdown (Options 5 & 6)
Option 5: Exporting to Disk
When choosing option 5, your program triggers file-writing pipelines to build a CSV file. Notice that any commas inside descriptions automatically get parsed out into spaces to preserve table rows:

Plaintext
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
5

LOG CREATED SUCCESSFULLY!
What the resulting file Study.csv looks like inside a text editor:

Code snippet
Date,Subject,Duration,Description
2026-06-08,Java,3.5,Learned OOP principles  encapsulation  and classes.
2026-06-08,Java,2.0,Debugged inheritance issues.
2026-06-08,OS,4.0,Read about multithreading and process synchronization.
Option 6: Graceful Program Exit
Plaintext
=====================PLEASE SELECT THE APPROPRIATE OPTION ========================
1 : Insert New Study Log Into Database 
2 : View All Study Logs 
3 : Summary Of Study Log By Date
4 : Summary Of Study Log By Subject
5 : Export Study Log To CSV File
6 : Exit the Application
6

=========================================================================================
============THANKS FOR USING MARVELLOUS STUDY TRACKER APPLICATION========================
=========================================================================================
