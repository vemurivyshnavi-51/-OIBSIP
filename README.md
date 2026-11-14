# -OIBSIP
Task 2: Number Guessing Game

Oasis Infobyte Internship | Java Development

A console-based number guessing game written in Java. The computer picks a random number and the player has a limited number of attempts to guess it, with "Too High" / "Too Low" hints after every guess.

Features
Random number generated with java.util.Random
Hints after each guess: Too High!, Too Low! or Correct!
Limited attempts per round, with attempts remaining shown
Three difficulty levels:
Level	Range	Attempts
Easy	1-50	10
Medium	1-100	7
Hard	1-200	5
Input validation: non-numeric and out-of-range guesses are rejected without costing an attempt
Play Again? option after every round
Score tracking across rounds, with a final summary of rounds played, won and lost
Concepts Used
Scanner for console input and Random for number generation
while loops, switch, methods and ArrayList
Exception handling (NumberFormatException) for input validation
Requirements
JDK 17 or later (check with java -version)
How to Run
bash
cd Java-Task2-NumberGuessingGame
javac NumberGuessingGame.java
java NumberGuessingGame
Sample Output
=================================
   WELCOME TO NUMBER GUESSING
=================================

Choose difficulty:
  1. Easy   (1-50,  10 attempts)
  2. Medium (1-100,  7 attempts)
  3. Hard   (1-200,  5 attempts)
Enter 1, 2 or 3: 2

--- Round 1 ---
I'm thinking of a number between 1 and 100. You have 7 attempts.
Attempt 1/7 - Enter your guess: 50
Too High!
Attempts left: 6
Attempt 2/7 - Enter your guess: 25
Too Low!
...
Correct! You guessed it in 5 attempt(s).

Play again? (y/n): n

=================================
          FINAL SCORE
=================================
Round 1 - guessed in 5 attempts
---------------------------------
Rounds played: 1 | Won: 1 | Lost: 0
Thanks for playing!
Screenshots

Add your screenshots to a screenshots/ folder and link them here:

Win Loss

What I Learned
Structuring a game loop with nested loops (rounds and attempts)
Validating user input safely with try/catch
Breaking a program into small, reusable methods



Task 3: ATM Interface
Oasis Infobyte Internship | Java Development

A console-based ATM simulation written in Java using object-oriented design. Users log in with a User ID and PIN, then can view their transaction history, withdraw, deposit and transfer money.

Features
Secure login with User ID and PIN, locked out after 3 failed attempts
Menu options:
Transaction History
Withdraw
Deposit
Transfer
Quit
"Insufficient Funds" handling on withdrawals and transfers
Transfers update both accounts and log a transaction on each
Input validation: negative, zero and non-numeric amounts, unknown recipient IDs, and transfers to your own account are all rejected
Timestamped transaction records
Project Structure
Class	Responsibility
Transaction	Stores type, amount, description and timestamp of one transaction
Account	Holds user ID, PIN, balance and history; provides deposit, withdraw and transfer
Bank	Stores all accounts, looks them up by ID and authenticates users
ATM	Login flow, menu loop and all user interaction
Main	Creates sample accounts and starts the ATM
Concepts Used
Object-oriented programming: encapsulation, classes and objects, separation of responsibilities
Collections: HashMap and ArrayList
java.time for timestamps and String.format for output
Control flow with switch and loops
Requirements
JDK 17 or later (check with java -version)
How to Run
bash
cd Java-Task3-ATMInterface
javac *.java
java Main
Test Accounts
User ID	PIN	Name	Opening Balance
1001	1234	Alice	Rs. 5000.00
1002	4321	Bob	Rs. 3000.00
1003	1111	Charlie	Rs. 10000.00
Sample Output
=================================
        WELCOME TO THE ATM
=================================

Enter User ID: 1001
Enter PIN: 1234

Welcome, Alice!

------------- MENU -------------
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option (1-5): 3
Enter amount to deposit: 500
Deposit successful. New balance: Rs. 5500.00
Screenshots

Add your screenshots to a screenshots/ folder and link them here:

Login Menu Transfer

Limitations

Account data is stored in memory, so balances and history reset every time the program is restarted. A database such as MySQL or SQLite could be added in a future version to make the data persistent.

What I Learned
Designing a program as several cooperating classes
Keeping data private and exposing behavior through methods
Handling invalid input and edge cases in a transaction flow
Author
[Vemuri Vyshnavi] Java Development Intern, Oasis Infobyte (#oasisinfobyte)
