@echo off
if exist "%JAVA_HOME%" goto okExec
echo Please set "JAVA_HOME"
pause
goto end

:okExec
java -jar derbyrun.jar server start