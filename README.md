1. **Download the JAR File**:
   - First, download the `mysql-connector-java` JAR file from the official MySQL website. This JAR file contains the JDBC driver necessary for connecting to a MySQL database¹.

2. **Open Your Java Project in Eclipse**:
   - Open Eclipse and navigate to your Java project where you want to use the MySQL Connector.

3. **Add the JAR to the Build Path**:
   - Right-click on your project in the Package Explorer.
   - Go to "Build Path" and select "Configure Build Path."
   - In the "Libraries" tab, ensure that "Classpath" is selected (not "Modulepath").
   - Click the "Add External JARs" button.
   - Locate and select the `mysql-connector-java-<version>.jar` file you downloaded.
   - Click "Apply" and then "Apply and Close" to save the changes².

4. **Set the Classpath Permanently (Optional)**:
   - If you want to set the classpath permanently, follow these steps:
     - Go to your system's environment variables.
     - Create a new variable named `CLASSPATH`.
     - Set the variable value to the path of the `mysql-connector.jar` file (e.g., `C:\yourfolder\mysql-connector-java-8.0.25;`)³.

5. **Verify the Configuration**:
   - Restart Eclipse or refresh your project.
   - You should now be able to use the MySQL Connector in your Java code.

Remember to replace `<version>` with the actual version number of the MySQL Connector JAR file you downloaded. 

