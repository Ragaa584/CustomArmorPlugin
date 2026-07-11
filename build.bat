@echo off
echo ========================================
echo CustomArmorPlugin Build Script
echo ========================================
echo.

REM Check if Maven is installed
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    echo Found Maven. Building with Maven...
    call mvn clean package
    if %ERRORLEVEL% EQU 0 (
        echo.
        echo ========================================
        echo BUILD SUCCESS!
        echo ========================================
        echo JAR file location: target\CustomArmorPlugin-1.0.0.jar
        echo.
        pause
        exit /b 0
    ) else (
        echo.
        echo Maven build failed. Please check the error messages above.
        pause
        exit /b 1
    )
)

REM Check if Gradle is installed
where gradle >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    echo Maven not found. Found Gradle. Building with Gradle...
    call gradle shadowJar
    if %ERRORLEVEL% EQU 0 (
        echo.
        echo ========================================
        echo BUILD SUCCESS!
        echo ========================================
        echo JAR file location: build\libs\CustomArmorPlugin-1.0.0.jar
        echo.
        pause
        exit /b 0
    ) else (
        echo.
        echo Gradle build failed. Please check the error messages above.
        pause
        exit /b 1
    )
)

echo ========================================
echo ERROR: Neither Maven nor Gradle found!
echo ========================================
echo.
echo Please install one of the following build tools:
echo.
echo 1. Maven (Recommended):
echo    - Download from: https://maven.apache.org/download.cgi
echo    - See BUILD_INSTRUCTIONS.md for detailed setup
echo.
echo 2. Gradle:
echo    - Download from: https://gradle.org/install/
echo.
echo 3. Use IntelliJ IDEA (Easiest):
echo    - Download IntelliJ IDEA Community Edition
echo    - Open this project as a Maven project
echo    - Click Maven tab → Lifecycle → package
echo.
pause
exit /b 1
