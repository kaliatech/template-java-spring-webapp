@echo off
set CATALINA_HOME=server
set JAVA_OPTS=-server -Xms128M -Xmx512M -XX:PermSize=256m -XX:MaxPermSize=512m
set JAVA_OPTS=%JAVA_OPTS% -Dconfig.dir=%CATALINA_HOME%\..\config -Ddatabase.dir=%CATALINA_HOME%\..\database
set JAVA_OPTS=%JAVA_OPTS% -XX:+CMSClassUnloadingEnabled -Djava.awt.headless=true
REM call "%~dp0\startup.bat" %*
call "%CATALINA_HOME%\bin\startup.bat" %*
