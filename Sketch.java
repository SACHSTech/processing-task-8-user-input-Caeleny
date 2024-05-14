import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
 // Set up the images and variables
 PImage img;
 PImage background;
 PImage earth;
 PImage saturn;

 float sunX;
 float sunY;

 float r;
 float g;
 float b;

 String message = "";
 
  public void settings() {
    // Background size
    size(400, 400);
    
  }
  
  public void setup() {

    // Load and resize all the images
    background = loadImage("background.jpg");
    background.resize(background.width/10, background.height/10);

    background(210, 255, 173);
    img = loadImage("star.png");
    img.resize(img.width/50, img.height/50);

    earth = loadImage("Earth.png");
    earth.resize(earth.width/15, earth.height/15);

    saturn = loadImage("saturn.png");
    saturn.resize(saturn.width/15, saturn.height/15);

    image(background,0,0);
  
  }
  
  public void draw() {
    
    // Print a star while the mouse is being pressed
    if (mousePressed) {
      image(img, mouseX, mouseY); 
    }

    // Move the sun in the direction of the direction arrows
    if (keyPressed) {
      image(background,0,0);
      if (keyCode == UP) {
        sunY--;
      } 
      else if (keyCode == DOWN) {
        sunY++;
      } 
      else if(keyCode == LEFT){
        sunX--;
      }
      else if(keyCode == RIGHT){
       sunX++; 
      }
      
    } 
    // Print the Sun
    fill(255,255,0);
    ellipse(sunX, sunY, 50, 50);

    // Type the last key pressed
    textSize(144);
    text(key, 50, 250);

    // Type all the keys pressed
    fill(0, 255, 0);
    textSize(20);
    text(message, 10, 390);

    // Change the color of the other circle
    fill(r, g, b);
    ellipse(5, 350, 50, 50);
    
  }

  // Print a picture of the earth when the mouse is clicked
  public void mouseClicked() {
      image(earth, mouseX, mouseY);
    }

  // Print a picture of saturn when the mouse wheel is drag
  public void mouseWheel(){
    image(saturn,mouseX,mouseY);
  }

  // Type down every key that is typed
  public void keyTyped() {
    message += key;
  }

  // Change the color of the circle when the mouse is moved
  public void mouseMoved(){
   
    int color1 = color(255, 0, 0); 
    int color2 = color(0, 0, 255); 
    
    // Alternate between the two colors   
    if (mouseX < width / 2) {
        
        r = red(color1);
        g = green(color1);
        b = blue(color1);

    } else {
   
        r = red(color2);
        g = green(color2);
        b = blue(color2);
    }
}
  }
