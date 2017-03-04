# JavaFXSupportsForJShell

## Overview
This is a JavaFX supporting library for jshell.
Include following:
- ExecutionControl to allow you to run JavaFX codes in jshell
- Useful scripts to build/try this library
- Useful initial startups to write your JavaFX codes
 - Imports all of JavaFX packages

jshell is a official Java REPL-Tool.
For more detail about jshell, visit http://openjdk.java.net/projects/kulla/

## Why is this necessary?
As you know, JavaFX requires that JavaFX related codes must be run in JavaFX thread.
But, JShell runs your code on main thread.
So your JavaFX code cannot be run in jshell as usually(Instead you will get an exception).

This is why you need this library to play JavaFX on jshell.

## How do work this with jshell
Install JDK9: https://jdk9.java.net/

I use JDK9b158 in this instruction.

Clone this repository and get into the repository:
```
$ git clone ...
$ cd JavaFXSupportsForJShell
```

Build it:
```
$ JAVA_HOME=/path/to/your/jdk9 sh scripts/compile.sh
$ JAVA_HOME=/path/to/your/jdk9 sh scripts/package.sh
```

Run it:
```
$ JAVA_HOME=/path/to/your/jdk9 sh scripts/jfxshell.sh
(in a few second later)
jshell> 
```

Type your JavaFX code(in the following snippet, jshell's outputs are omitted):

Note that you don't need to import anything about JavaFX package because the startup will import everything instead!

```
jshell> Button button = new Button("Click me!")
jshell> button.setOnAction(e -> System.out.println("HelloWorld!"))
jshell> Scene scene = new Scene(button)
jshell> Stage stage = new Stage()
jshell> stage.setScene(scene)
jshell> stage.setWidth(200)
jshell> stage.setHeight(300)
jshell> stage.setTitle("Hello JavaFX with JShell")
jshell> stage.show()
```

(prompt omitted version)
```
Button button = new Button("Click me!")
button.setOnAction(e -> System.out.println("HelloWorld!"))
Scene scene = new Scene(button)
Stage stage = new Stage()
stage.setScene(scene)
stage.setWidth(200)
stage.setHeight(300)
stage.setTitle("Hello JavaFX with JShell")
stage.show()
```

Enjoy your jshell&JavaFX life!!

Any comments, feedbacks, issues or PRs are welcome!!

## Contributors
bitter_fox(@bitter_fox) -- Owner
