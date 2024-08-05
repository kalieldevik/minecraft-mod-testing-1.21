# Learning and Testing Minecraft Mods!

### Process:

- Delete **LICENSE** and **.github** files
- Open project in IntelliJ
  - After doing this: 
    - Build the project (using the icon or **CTRL + F9**)
    - Go to **File > Project Structure** and ensure SDK and Language Level are both correct. For this it is **17**
    - Go to **File > Settings > Build, Execution, Deployment > Gradle** and ensure the **Gradle JVM** is set to the correct version. **JAVA_HOME** should be using version **17** for this
      - If **JAVA_HOME** does *not* have version 17, you can set **Project SDK** to **17**