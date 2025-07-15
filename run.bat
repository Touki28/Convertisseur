@echo off
REM Crée le dossier class s'il n'existe pas
if not exist class (
    mkdir class
)

REM Compile les fichiers listés dans src/compile.list vers class
javac -d class @src/compile.list
if errorlevel 1 (
    echo Compilation a echoue.
    pause
    exit /b 1
)

REM Lance l'application (modifie si ta classe principale est différente)
java -cp class src.Controleur

pause