@echo off
set JAVA_OPTS=-server -Xms128M -Xmx512M -XX:PermSize=256m -XX:MaxPermSize=512m
set JAVA_OPTS=%JAVA_OPTS% -Dconfig.dir=%CATALINA_HOME%\..\config -Ddatabase.dir=%CATALINA_HOME%\..\database
set JAVA_OPTS=%JAVA_OPTS% -XX:+CMSClassUnloadingEnabled -Djava.awt.headless=true
set JAVA_OPTS=%JAVA_OPTS% -Xdebug -Xrunjdwp:transport=dt_socket,address=12000,server=y,suspend=n
set JAVA_OPTS=%JAVA_OPTS% -noverify -javaagent:%JREBEL_HOME%\jrebel.jar

REM http://manuals.zeroturnaround.com/jrebel/misc/index.html#agent-settings
REM set JAVA_OPTS=%JAVA_OPTS% -Drebel.log=true -Drebel.log.file=C:\Temp\jrebel.log
REM set JAVA_OPTS=%JAVA_OPTS% -Drebel.log.stdout=false


REM call "%~dp0\startup.bat" %*
call "%CATALINA_HOME%\bin\startup.bat" %*
