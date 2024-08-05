# Learning and Testing Minecraft Mods!

### Process For Setting Up Template
- If using the Fabric template mod generator:
  - Input desired mod name
  - Select "**Use custom id**" next to the **Mod Name** input section
  - Input desired mod id (Note: make sure it is all lower case with no spaces or special characters other than underscore or hyphen)
  - Input desired package name. This should follow a similar naming scheme to net.name.modid`
  - Select Minecraft version
  - For Advanced Options
    - Check **Data Generation**
    - Uncheck **Split client and common resources** 
      - Do this only if your mod will be installed on servers to prevent the server from calling client code that can potentially cause crashes

### Process For Setting Up Environment:
#### **ASSUMES INTELLIJ**
- Delete **LICENSE** and **.github** files
- Open project in IntelliJ
  - After doing this: 
    - Build the project (using the icon or CTRL + F9`)
    - Go to `File > Project Structure` and ensure **SDK** and **Language Level** are both correct. For this it should be **17**
    - Go to `File > Settings > Build, Execution, Deployment > Gradle` and ensure the **Gradle JVM** is set to the correct version. **JAVA_HOME** should be using version **17**
      - If **JAVA_HOME** does *not* have version **17**, you can set **Project SDK** to **17**


### Process for Setting up Files

#### Step 1
- Navigate to src/main/java/net/name/modid/ClassName.java`
  - Remove unnecessary code (usually comments if using template)
  - Make sure to correct class name if you used a template!! Do this for the main mod file, and the **ClassNameDataGenerator** Java file
  - Create a new line directly under the class creation that includes the following code:
    - public static final String MOD_ID = "yourmodid";`
    - This code will help make your modding experience much easier. By representing your mod id with the name of this constant string, "**MOD_ID**", you can reduce the amount of typing when you need to inevitably enter your mod id in many different places
  - Create a new Java class with the name "**ClassNameClient**" in the same directory as your other files
    - In the class declaration line after the name, add in the following code: 
      - `implements ClientModInitializer`
    - If you use your tab key when typing this, it should also add in a package import at the top. If it does not, you also need to add in the following code: 
      - import net.fabricmc.api.ClientModInitializer;
    - If you hover over `ClientModInitializer` in your class declaration line, it should give you the option to implement the `onInitializeClient` method. If it does not do this, add in the following code into your class:
      - ```
        @Override
        public void onInitializeClient() {
        
        }
        ```

#### Step 2
- Navigate to ```src/main/resources```
  - Delete any unnecessary files 
    - An Example would be .png icons in your ```assets/modname```


#### Step 3
- Navigate to ```resources/modname.mixins.json```
  - Edit **description**
  - Edit **authors**
  - Edit **contact** (low priority)
  - Edit **license**
  - Edit **entrypoints** to correspond to your Java class names
    - Add in ```"client"``` which will include ```"net.name.modid.ClassNameClient"```
  - Edit **depends** to correspond to Java version. For this it will be **>=17**
