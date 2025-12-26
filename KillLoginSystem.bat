@echo off
echo Killing LoginSystem installer and Java processes...
taskkill /F /IM LoginSystem-1.0.exe >nul 2>&1
taskkill /F /IM LoginSystem.exe >nul 2>&1
taskkill /F /IM java.exe >nul 2>&1
taskkill /F /IM javaw.exe >nul 2>&1
echo Done.
pause
