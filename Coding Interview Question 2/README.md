# **HTML `<div>` Tag Fixer Program**

### Description:

This program reads an HTML string input from the user and corrects nested \<div> tags by ensuring only one \<div> tag is present without its corresponding closing \</div> tag. This functionality is implemented in the interviewQ2 class.

interviewQ2 Class - 
The interviewQ2 class provides the main functionality of the program.

HTML Tag Correction Logic:

The htmlDivFixer method processes each character in the input HTML string.<br/>
It identifies \<div> tags and ensures that if more than one \<div> tag is found without a corresponding closing \</div> tag, it adds a closing \</div> tag before adding a new \<div> tag.<br/>
This ensures that the HTML string is corrected to have properly nested and balanced \<div> tags.<br/>

### How it works:

#### interviewQ2 Class:

**Methods**:<br/>
**main(String[] args)**:<br/>
Entry point of the program. Prompts the user for an HTML string input, calls the htmlDivFixer method to fix the HTML string, and prints the corrected HTML string.<br/>
htmlDivFixer(String html): Takes an HTML string as input and returns a new string with corrected \<div> tags. Ensures there is only one \<div> tag without a closing \</div> tag.<br/>

### Examples:

Input:

\<div>\<p>Here is a \<div> tag \</p>

Output:

\<div>\<p>Here is a \</div> tag \</p>

### Requirements:

JDK 8 or higher.<br/>
