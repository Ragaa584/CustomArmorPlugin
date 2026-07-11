@echo off
echo ========================================
echo CustomArmorPlugin - Auto Install and Build
echo ========================================
echo.
echo This window will stay open so you can see all details.
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed!
    echo Please install Java 17 or higher from: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)

echo Java is installed.
echo.

REM Check if Maven is already installed
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    echo Maven is already installed.
    echo.
    goto :build
)

echo Maven is not installed. Downloading and installing...
echo.

REM Create temp directory
if not exist "%TEMP%\maven-install" mkdir "%TEMP%\maven-install"
cd /d "%TEMP%\maven-install"

REM Download Maven
echo Downloading Maven...
powershell -Command "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip' -OutFile 'maven.zip'"
if %ERRORLEVEL% NEQ 0 (
    echo Trying alternative download source...
    powershell -Command "Invoke-WebRequest -Uri 'https://downloads.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip' -OutFile 'maven.zip'"
    if %ERRORLEVEL% NEQ 0 (
        echo ERROR: Failed to download Maven.
        echo Please download manually from: https://maven.apache.org/download.cgi
        echo.
        echo Manual installation steps:
        echo 1. Go to: https://maven.apache.org/download.cgi
        echo 2. Download apache-maven-3.9.5-bin.zip
        echo 3. Extract it to C:\Program Files\
        echo 4. Run this script again
        pause
        exit /b 1
    )
)

REM Extract Maven
echo Extracting Maven...
powershell -Command "Expand-Archive -Path 'maven.zip' -DestinationPath 'C:\Program Files\' -Force"

REM Set environment variables for this session
set MAVEN_HOME=C:\Program Files\apache-maven-3.9.5
set PATH=%PATH%;%MAVEN_HOME%\bin

REM Add to permanent PATH (requires admin)
echo Adding Maven to system PATH...
setx MAVEN_HOME "C:\Program Files\apache-maven-3.9.5" /M >nul 2>&1
setx PATH "%PATH%;C:\Program Files\apache-maven-3.9.5\bin" /M >nul 2>&1

echo Maven installed successfully!
echo.

REM Go back to project directory
cd /d "C:\Users\Al-Ansar Technology\CascadeProjects\CustomArmorPlugin"

:build
echo ========================================
echo Building CustomArmorPlugin...
echo ========================================
echo.

echo Current directory:
cd
echo.

echo Listing files in current directory:
dir
echo.

echo Running Maven build...
call mvn clean package
echo.

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo BUILD SUCCESS!
    echo ========================================
    echo.
    echo Your JAR file is located at:
    echo target\CustomArmorPlugin-1.0.0.jar
    echo.
    echo You can now copy this file to your server's plugins folder.
    echo.
    pause
    exit /b 0
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
    echo.
    echo Please check the error messages above.
    echo Common issues:
    echo - No internet connection
    echo - Firewall blocking downloads
    echo - Insufficient permissions
    echo.
    pause
    exit /b 1
)
