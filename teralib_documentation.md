# Teralib Documentation

Teralib is very simple to use, and I shall prove that here!

Once you're done getting the VERY few lines of boilerplate code out of the way, you can begin programming your
game!

# How it's done:

In README.md, you should've followed the basic set up routine. Once done, read this!

Take a look in the `render()` function inside your class that `extends MainLauncher`.
It is currently very empty, as seen. In order to actually get something rendering to the screen,
you need to access the main window's `Bitmap` or render texture.

That is done by (in `render()` inside your class that `extends MainLauncher`) creating a `BufferStrategy`.

```java
@Override
public void render() {
	BufferStrategy bs = null;
}
```

We need to, again, access the main window's `Bitmap` in order to get the draw buffer.

```java
@Override
public void render() {
	BufferStrategy bs = bitmap.getDrawBuffer();
}
```

We now have access to the draw buffer! Hooray! Well, not quite.
You see, the `bs` variable is currently `null`, how do we fix this?

By doing:

```java
@Override
public void render() {
	BufferStrategy bs = bitmap.getDrawBuffer();
	if (bs == null) {
		bitmap.createBufferStrategy(3);
		return;
	}
}
```

There we go! It's no longer null, and, that `3` you see there is just the number of buffers.
This framework supports numerous amounts of buffers, I recommend `3` as it is not too much, nor too little.

Now we need to create a `Graphics` object to store the drawable graphics.

```java
@Override
public void render() {
	BufferStrategy bs = bitmap.getDrawBuffer();
	if (bs == null) {
		bitmap.createBufferStrategy(3);
		return;
	}
	Graphics g = bs.getDrawGraphics();
}
```

We now have full access to the graphics required to draw to the screen!
Now we just need to show the buffers, and dispose any unused graphics.

```java
@Override
public void render() {
	BufferStrategy bs = bitmap.getDrawBuffer();
	if (bs == null) {
		bitmap.createBufferStrategy(3);
		return;
	}
	Graphics g = bs.getDrawGraphics();

	/* Rendering code goes here */

	bs.show();
	g.dispose();
}
```
 
`bs.show();` makes sure that the buffer is properly drawn onto `bitmap`.
`g.dispose();` rids any unused graphics.

Awesome! Now, let's test it!

Inside `render()`, write the following lines of code in between the creation of the graphics,
and showing the buffer and disposing the graphics (in between `Graphics g = bs.getDrawGraphics();` and `bs.show();`)

```java
g.setColor(Color.GREEN);
g.fillRect(0, 0, WIDTH, HEIGHT);
```

When ran, this should change the colour of the background to green!
Awesome! You've rendered your first thing using the Teralib game framework!

Continue reading to learn more about Teralib!

# What the functions do

I will walk you through the process of figuring out what all the built in functions in Teralib do!

# What is tick?

The function `tick()` is the main update function, that is where your game logic shall be added.
`tick()` runs 60 times a second, making all games run at 60 frames per second.

The `tick()` function is located in your class that extends `MainLauncher`, and looks like this:

```java
@Override
public void tick() {
	/* Game logic goes here */
}
```

# What is render?

The function `render()` is the function that shall draw anything to the screen, you can draw objects
via the `bitmap`'s render texture. Say I have an object with a `draw()` function that takes in 
`Graphics g` as an argument. The graphics argument is needed so that you can pass in the main `Graphics`
object as an argument to the `draw(Graphics g)` function, in order to draw whatever you'd want.

The `render()` function is located in your class that extends `MainLauncher`, and should look like this:
```java
@Override
public void render() {
	BufferStrategy bs = bitmap.getDrawBuffer();
	if (bs == null) {
		bitmap.createBufferStrategy(3);
		return;
	}
	Graphics g = bs.getDrawGraphics();

	/* Rendering code goes here */

	bs.show();
	g.dispose();
}
```