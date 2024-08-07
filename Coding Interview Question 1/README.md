# **Letter Humps Capitalization Program**

### Description:

This program reads a string input from the user and capitalizes alternate letters, starting with the first letter. The program continues to prompt the user for input until the user enters 'q' to exit. This functionality is implemented in the interviewQ1 class.

interviewQ1 Class - 
The interviewQ1 class provides the main functionality of the program.

Capitalization Logic:

The letterHumps method processes each character in the input string.<br/>
It capitalizes characters at even indices and converts characters at odd indices to lowercase.<br/>
This creates a "humps" effect, alternating between uppercase and lowercase letters.<br/>

### How it works:

#### assign3 Class:

**Methods**:<br/>
**main(String[] args)**:<br/>
Entry point of the program. Continuously prompts the user for input until the user enters 'q'. For each input string, it calls the letterHumps method to capitalize alternate letters.<br/>
letterHumps(String word): Takes a string as input and returns a new string with alternate letters capitalized.<br/>

### Examples:

Input:

Please enter a string to be capitalized <br/>
Otherwise type 'q' to exit<br/>
hello world<br/>

Output:

HeLlO WoRlD

### Requirements:

JDK 8 or higher.<br/>
