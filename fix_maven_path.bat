@echo off
echo ========================================
echo Maven PATH Fix Tool
echo ========================================
echo.

REM Check if Maven folder exists
if exist "C:\Program Files\apache-maven-3.9.5\bin\mvn.cmd" (
    echo Maven found at: C:\Program Files\apache-maven-3.9.5
    echo.
    echo Adding to PATH...
    
    REM Add to PATH for current session
    set PATH=%PATH%;C:\Program Files\apache-maven-3.9.5\bin
    
    REM Add to permanent PATH
    setx PATH "%PATH%;C:\Program Files\apache-maven-3.9.5\bin" /M >nul 2>&1
    
    echo Maven added to PATH successfully!
    echo.
    echo Testing Maven...
    call "C:\Program Files\apache-maven-3.9.5\bin\mvn.cmd" -version
    
    if %ERRORLEVEL% EQU 0 (
        echo.
        echo ========================================
        echo SUCCESS! Maven is working!
        echo ========================================
        echo.
        echo Now you can build the plugin.
        echo.
        echo Press any key to start building...
        pause >nul
        
        cd /d "C:\Users\Al-Ansar Technology\CascadeProjects\CustomArmorPlugin"
        call "C:\Program Files\apache-maven-3.9.5\bin\mvn.cmd" clean package
        
        if %ERRORLEVEL% EQU 0 (
            echo.
            echo ========================================
            echo BUILD SUCCESS!
            echo ========================================
            echo.
            echo Your JAR file is at: target\CustomArmorPlugin-1.0.0.jar
            echo.
        ) else (
            echo.
            echo BUILD FAILED. Check errors above.
        )
    ) else (
        echo Maven test failed. Please check installation.
    )
    
) else (
    echo ========================================
    echo ERROR: Maven not found!
    echo ========================================
    echo.
    echo Please make sure you extracted Maven to:
    echo C:\Program Files\apache-maven-3.9.5
    echo.
    echo If you extracted it somewhere else, please tell me the path.
    echo.
)

pause
