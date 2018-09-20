# Teralib

Teralib, a simple yet fast Java game framework that does all the nitty-gritty stuff for you!

Setting Teralib up with your project is pretty simple, just download the .jar file called "Teralib.jar" and include it in your project!
When that's done, getting into the game development is not difficult at all!

REMINDER: Remember to import the files from the framework that's necessary!

Step One: Create a class that extends `MainLauncher`
E.G.
```java
public class Game extends MainLauncher {

	/* ... */
	
}
```

Step Two: Create the required methods and constructor
E.G.
```java
public class Game extends MainLauncher {

  	public Game(String title, int width, int height, boolean resizable, Bitmap bitmap) {
		super(title, width, height, resizable, bitmap);
	}

	@Override
	public void init() {
	}

	@Override
	public void render() {
	}

	@Override
	public void tick() {
	}
	
}
```

Step Three: Call the `start();` method for `Game`
In another class or in the same one, create the main method:
(Launcher.java)
```java
public class Launcher {

	public static void main(String[] args) {
		Bitmap bitmap = new Bitmap(640/*width*/, 480/*height*/);
		Game game = new Game("Title", 640/*width*/, 480/*height*/, true/*resizable*/, bitmap/*bitmap*/);
		game.start();
	}
	
}
```

Now run the code and see a little window pop up with all the modifications you gave it!

