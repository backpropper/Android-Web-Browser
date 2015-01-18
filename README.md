Android-Web-Browser
===================

#Voice and speech based web browser

1. The main layout has two options:
    i. Text field for URL.
          If the text field is not empty then the button acts as a normal button and when pressed will open the
          corresponding URL.
   ii. A button to activate speech to text engine.
          If the text field is empty and the button is pressed then speech engine is activated and anything spoken
          by the user is interpreted as a URL. (eg. "google" will be translated to "http://www.google.com/").

2. URL entered from the main layout is opened in a webview. 
    On the bottom of the layout is a button which activates the voice engine. The following output of the 
    speech engine are:

      i. 'back' : Previous webpage is opened.
      
     ii. 'forward' : Next webpage is opened.
     
    iii. 'stop' : Loading of the webpage is stopped.
    
     iv. 'refresh' : Current webpage is refreshed.
     
      v. 'speak' : Any text copied to the clipboard is read aloud.
      
     vi. If the output of the speech engine is anything else than the above 5 then that string is searched on "google" 
         provided that google is the current webpage.

3. On main layout if the input to the speech engine is "email" then email layout if opened which can be used to
   login to Gmail, AOL, Yahoo and BITS mail.

#Contibutor:
Abhinav Gupta