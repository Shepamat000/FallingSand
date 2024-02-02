@echo off
javac fallingsand/Main.java fallingsand/View.java fallingsand/Controller.java fallingsand/Settings.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Physics Engine...
	java fallingsand.Main	
)
pause