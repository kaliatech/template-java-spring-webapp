ECHO OFF
ECHO.
IF EXIST ..\..\local\win32\env.local.bat call ..\..\local\win32\env.local.bat

IF NOT EXIST ..\..\local\win32\env.local.bat ECHO Error: env.local.bat Not Found!!! Look at ..\..\local_examples directory.
IF NOT EXIST ..\..\local\win32\env.local.bat mkdir ..\..\local\win32
IF NOT EXIST ..\..\local\win32\env.local.bat PAUSE

SET PATH=%JAVA_HOME%\bin
SET PATH=%PATH%;%CATALINA_HOME%\bin
SET PATH=%PATH%;%ANT_HOME%\bin
SET PATH=%PATH%;%M2_HOME%\bin
SET PATH=%PATH%;%PROJECT_HOME%\misc\env\common\win32\scripts
SET PATH=%PATH%;%PROJECT_HOME%\misc\env\local\win32
SET PATH=%PATH%;%PROJECT_HOME%
SET PATH=%PATH%;%windir%
SET PATH=%PATH%;%windir%\System32


REM This is the first classpath statement encountered. (Otherwise we'd append to existing Classpath.)
REM SET CLASSPATH=%ANT_HOME%\lib\ant.jar

cd "%PROJECT_HOME%"\workspace_java

ECHO Common Environment Setup.

IF EXIST "%PROJECT_HOME%\misc\env\user\win32\env.user.bat" call "%PROJECT_HOME%\misc\env\user\win32\env.user.bat"

ECHO.

