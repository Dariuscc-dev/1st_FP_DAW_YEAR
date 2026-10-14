# First steps in Java

As we introduced ourselves in the matter, we learned that the right way to start coding in Java is to work wwith the Eclipse compiler, we had to download the JDK and also JVM.

I first had to also configure the environment varibale of eclipse to be able to strat it from the PowerShell with = eclipse -data "xyz path" 

Then, I also realized that the compiler I use doesn´t limit me to use the powershell alongside with github CLI to do CI/CD, eeither from Eclipse or VSC (which is the one that I'm the most familair with).

So from now on, I will do CI/CD from the powershell as always with =

- eclipse -data "xyz path" (EXTRA)
- git add .
- git status
- git commit -m "feat"
- git push -u origin 00-fork
- gh pr create
- gh pr merge

We then started a new project inside of Eclipse, where we first created a java project, then a java package, and lastly, a java public stativ void main class, where the class' name has to be the same as the file´s name.

We then went into exploring different data types, declaring and initializing variables/constants.

Some other basic stuff like system.out.println()...etc

