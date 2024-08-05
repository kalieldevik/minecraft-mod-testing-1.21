# Learning and Testing Minecraft Mods!

Based on https://docs.fabricmc.net/develop/ and Modding by Kaupenjoe YouTube videos

## Process For Initial Setup

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
    - Go to `File > Project Structure` and ensure **SDK** and **Language Level** are both correct. For this it should be **21**
    - Go to `File > Settings > Build, Execution, Deployment > Gradle` and ensure the **Gradle JVM** is set to the correct version. **JAVA_HOME** should be using version **21**
      - If **JAVA_HOME** does *not* have version **21**, you can set **Project SDK** to **21**


### Process for Setting up Files

#### Step 1
- Navigate to `src/main/java/net/name/modid/ClassName.java`
  - Remove unnecessary code (usually comments and a random `LOGGER.info` example if using template)
  - Make sure to correct class name if you used a template!! Do this for the main mod file, and the **ClassNameDataGenerator** Java file
  - Create a new line directly under the class creation that includes the following code:
    - `public static final String MOD_ID = "yourmodid";`
    - This code will help make your modding experience much easier. By representing your mod id with the name of this constant string, "**MOD_ID**", you can reduce the amount of typing when you need to inevitably enter your mod id in many different places
  - Create a new Java class with the name "**ClassNameClient**" in the same directory as your other files
    - In the class declaration line after the name, add in the following code: 
      - `implements ClientModInitializer`
    - If you use your tab key when typing this, it should also add in a package import at the top. If it does not, you also need to add in the following code: 
      - import net.fabricmc.api.ClientModInitializer;
    - If you hover over `ClientModInitializer` in your class declaration line, it should give you the option to implement the `onInitializeClient()` method. If it does not do this, add in the following code into your class:
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
  - Edit **depends** to correspond to Java version. For this it will be **>=21**

#### Step 4
- Navigate to your main directory, and you will find the `gradle.properties` file
  - You can edit the "Mod Properties" section to correspond to your mod.
    - The first change should be the `mod_version`
      - The version itself is intuitive enough, just set it to the current iteration of your mod. However, it may be good practice to put a hyphen, and then the Minecraft version your mod is compatible with after as well to give more information and be more user friendly
        - For example, `mod_version=mod.version-minecraft.version` (don't keep the alpha characters in the version)
  - **After editing anything gradle-related**
    - Press "Load Gradle Changes" to ensure everything works correctly.
      - This is located in the upper right with a small elephant icon.
      - **If you get an incompatible Java version error after loading Gradle and building**: refer to earlier steps in this process and ensure you are on the correct Java version for the Minecraft version you're running
  - After doing this, open the terminal and type `./gradlew genSources` (may take a couple minutes to download and build)
    - This is done to download sources that allow you to go into the source code to do cool stuff!

#### Step 5
- Navigate to `src/main/java/net/name/modid/mixin`
  - Open `ExampleMixin.java`
  - Middle mouse click on **MinecraftServer** found in `@Mixin(MinecraftServer.class)`
    - This will open `MinecraftServer.class` with a blue line at the top. In this blue line click on **Choose Sources...** in the upper right
      - This will open up a new window, and you can select the correct file. The correct file will be same name as the one automatically selected, but will have **-sources** at the end before the file extension.

#### Step 6
- To initially run the client:
  - Click the Gradle tab on the right
  - Expand the following: `Tasks > Fabric`
  - Double-click on **runClient** and the game should start!
    - You will get a 401 error when you launch the game. This is completely normal when using the dev environment and can be ignored
- After you've run it using the above method, restart IntelliJ
  - Once you've restarted, in the upper right, there is a dropdown to the left of the Run button
  - Select **Minecraft Client** from the dropdown, and you can start the game using the Run button!

### After this, the initial setup is complete! It is recommended to make a copy of this mod to reduce the amount of times you may need to go through this process for any subsequent mods you create.