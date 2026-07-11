# Build Instructions - CustomArmorPlugin

## Option 1: Using IntelliJ IDEA (Recommended for beginners)

1. Download and install IntelliJ IDEA Community Edition (free)
   - https://www.jetbrains.com/idea/download/

2. Open the project:
   - File → Open → Select `CustomArmorPlugin` folder
   - Select "Open as Project"

3. Build the project:
   - Click on the Maven tab on the right side
   - Expand "CustomArmorPlugin"
   - Expand "Lifecycle"
   - Double-click on "package"

4. Find your JAR file:
   - Go to `target` folder in the project directory
   - Find `CustomArmorPlugin-1.0.0.jar`

## Option 2: Installing Maven

### Windows Installation:

1. Download Apache Maven:
   - https://maven.apache.org/download.cgi
   - Download `apache-maven-3.9.5-bin.zip` (or latest version)

2. Extract the zip file to a folder (e.g., `C:\Program Files\Maven`)

3. Set environment variables:
   - Press Win + X → System → Advanced system settings
   - Click "Environment Variables"
   - Under "System variables", click "New"
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Program Files\Maven\apache-maven-3.9.5` (adjust path)
   - Click "OK"

4. Update PATH variable:
   - Find "Path" under "System variables"
   - Click "Edit"
   - Click "New"
   - Add: `%MAVEN_HOME%\bin`
   - Click "OK" on all windows

5. Verify installation:
   - Open new Command Prompt
   - Type: `mvn -version`
   - You should see Maven version information

6. Build the plugin:
   - Open Command Prompt in the project folder
   - Type: `mvn clean package`
   - Wait for build to complete
   - Find JAR in `target` folder

## Option 3: Using Eclipse

1. Download and install Eclipse IDE for Java Developers
   - https://www.eclipse.org/downloads/

2. Import as Maven project:
   - File → Import → Maven → Existing Maven Projects
   - Browse to `CustomArmorPlugin` folder
   - Click "Finish"

3. Build:
   - Right-click on project → Run As → Maven build
   - Goals: `clean package`
   - Click "Run"

4. Find JAR in `target` folder

## Option 4: Online Build Services

You can use online services like GitHub Actions or other CI/CD platforms to build the project automatically.

## After Building

Once you have the JAR file:

1. Place `CustomArmorPlugin-1.0.0.jar` in your server's `plugins` folder
2. Restart your Minecraft server
3. The plugin will create necessary folders automatically
4. Configure your custom armors in `plugins/CustomArmorPlugin/armors/`

## Troubleshooting

### Build fails with "compiler errors"
- Make sure you have Java 17 or higher installed
- Verify JDK is configured in your IDE

### "Cannot resolve symbol" errors in IDE
- Wait for Maven to finish downloading dependencies
- Right-click project → Maven → Reload Project

### JAR file not found
- Check the `target` folder in your project directory
- Make sure the build completed successfully (look for "BUILD SUCCESS" message)

## Need Help?

If you encounter any issues during the build process:
- Check that Java 17+ is installed: `java -version`
- Verify Maven installation: `mvn -version`
- Ensure you're in the correct directory with `pom.xml` file
