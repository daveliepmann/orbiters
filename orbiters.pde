// Reverse engineered from "orbiters": http://beesandbombs.tumblr.com/post/45513650541/orbiters
// ...plus color

int maxX;
int maxY;
int sizeIncrement = 20;

float px, py, angle;
float radius = 15;

int counter;

void setup() {
  maxX = displayWidth/2;
  maxY = displayHeight/2;
  size(maxX, maxY);
  smooth();
  noStroke();
  ellipseMode(CENTER);
}

void draw() {
  colorMode(RGB);
  background(220,220,250);

  colorMode(HSB);
  counter=0;
  for (int x=-10; x < maxX*2; x+=sizeIncrement) {
    counter++;
    for (int y=-10; y < maxY*2; y+=sizeIncrement) {
      px = x + (cos(radians(angle+x+y))*(radius));
      py = y + (sin(radians(angle+x+y))*(radius));
      fill(int(map(counter, 0, int(maxX/sizeIncrement), 0,255)), 170, 222);
      ellipse(px, py, 13, 13);
    }
  }
  angle += 2;
}
