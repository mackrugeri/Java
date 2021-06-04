/* 
    IGNORE THIS CODE. 

*/ 
void assessmentSetup( ) 
{ 
  correctMark = loadImage( "noun_correct_3036907.png"); 
  lastMarks  =  loadStrings( dataPath("TempMarks.txt"));//loadStrings(sketchPath("")+"data/TempMarks.txt" );
} 
void afterMarking( ) 
{ 
  Ariel = createFont("Arial", 18 ) ; 
  textFont( Ariel ); 
  
  for ( int a = 1; a < correct.length; a++ ) 
  { 
     correct[ a ] = Assessment3.correct(a ); 
  } 
  processCelebration( correct, lastMarks ) ; 
} 



PFont Ariel  ; 
boolean correct[ ] = new boolean[ 13 ] ; 
PImage correctMark ; 

String lastMarks[ ] ; 
boolean cellerbrate = false ; 
//--------------------------------------------------------
/*
  The code here isn't the cleanest. 
  There is some redundancy in this experimental code. 
*/
void processCelebration ( boolean correct[ ], String last[ ]  ) 
{ 
  assert correct !=null  ; 
  if ( last == null ) 
  { 
    //println("not found marking"); 
    last = new String[ correct.length  + 1 ] ; 
    for ( int a = 0; a < correct.length; a++ ) 
    { 
      last[a] = ""+correct[a]; // save old
    } 
    saveStrings(  dataPath("TempMarks.txt"), last);  
    return ;
  }

  for ( int a = 0; a < correct.length; a++ ) 
  { 
    boolean lastTime =  boolean ( last[ a ]  ); 
    if ( lastTime != correct[ a ] && lastTime== false  ) 
    { 
      println(" NEW CORRECT" + a  + " WELL DONE" ) ; 
      cellerbrate = true ;
    }
  }

  String save[]  = new String[ correct.length  + 1 ] ; 
  for ( int a = 0; a < correct.length; a++ ) 
  { 
    save[a] = ""+correct[a]; // save old
  } 
   saveStrings( dataPath("TempMarks.txt"), save);
} 
//---------------------------------------------------------
Firework fireworks[ ]  ; 
//---------------------------------------------------------
void draw()
{ 
  if( cellerbrate == true ) 
  { 
    background( 0) ; // black  
  } 
  else 
  { 
     background( 255) ; // white 
  } 
  fill( 0  ) ; 
  textSize( 16 ) ;
  textAlign( LEFT, TOP ) ; 
  int index = 40 ;  
  for ( int a = 1; a < correct.length; a++ ) 
  { 
    String result = "" ; 
    if ( correct[a] ) 
    { 
      fill( #20E807 ) ; 
      result  = "Q" + a + " CORRECT " ; 

      image( correctMark, 5, index, 25, 25  ) ; // better color
    } else 
    {  
      fill( 0 ) ; 
      result  = "Q" + a + "  " ;
    } 
    text( result, 30, index);  
    index += 25;
  } 

  int cm = Assessment3.getCurrnetMarks() ; 
  fill( 0 ); 
  text( "Total Marks so far = " + cm +" ", 30, index  );
  index +=30;  
 /*  String errors = Assessment3.getLastErrorMessage(); 
  if ( errors != null ) 
  { 
    text("last message was " errors, 20, index, width - 30, 100 );
  } 
  */ 

  if ( cellerbrate  == true ) 
  { 
    if( fireworks == null ) 
    { 
      println("Make firework");
      fireworks = new Firework[ 15 ] ; 
      for( int a = 0 ; a < 15; a++ ) 
      { 
        fireworks[a] = new  Firework() ; 
        fireworks[a].launch( ) ;
      } 
       
    } else
    { 
      for( Firework f: fireworks) 
      { 
        f.draw() ;
      } 
    } 
    
    textSize( 60 ) ; 
    fill( #EAFA0F ) ; 
    textAlign( CENTER, CENTER ) ; 
    text("Well Done!", width/2, height /2  );
  }
  drawDeliveryTime(); 
}
//-----------------------------------------------------------------------------------
void drawDeliveryTime() 
{ 
  LocalDateTime now = LocalDateTime.now(); 
  LocalDateTime delivery =  LocalDateTime.of( 2021, Month.JANUARY, 18, 13, 30, 0); 
  //.. LocalDateTime delivery =  LocalDateTime.of( 2019, Month.DECEMBER, 7, 15, 55, 0); 

  long diff = SECONDS.between( now, delivery ) ; 
  boolean late = false ; 
  if ( diff < 0 ) {  
    diff = -diff ; 
    late = true ;
  } 
  int days = 0 ; 
  if ( diff > ( 24*60*60))
  { 
    days = (int)diff/ ( 24*60*60); 
    diff = diff - (days*24*60*60);
  }
  int hours = 0 ; 
  if ( diff > 60*60 ) 
  { 
    hours = (int) (diff / ( 60*60)) ; 
    diff = diff - ( hours*60*60);
  } 
  int minutes = 0 ; 
  if ( diff > 60 ) 
  { 
    minutes =  (int) diff/(60) ; 
    diff = diff -(minutes *60);
  } 
  fill( 128 ) ; // white.

  if ( days == 0 ) 
  { 
    fill(#E60CEA ); // purpose
  } 

  String msg = "Time left D:" ; 
  if ( late == true ) 
  { 
    fill( #EA0C53 ) ; 
    msg = "LATE ! D:" ;
  } 
  text( msg + days+" H:"+hours+" M:"+minutes + " S:"+diff, width - 250, 22 ) ;
} 

// Example of a class in action 

class Firework
{
  float x, y, oldX,oldY, ySpeed, targetX, targetY, explodeTimer, flareWeight, flareAngle;
  int flareAmount, duration;
  boolean launched,exploded,hidden;
  color flare;
  Firework()
  {
    launched = false;
    exploded = false;
    hidden = true;
  }
  void draw(){
    if((launched)&&(!exploded)&&(!hidden)){
      launchMaths();
      strokeWeight(1);
      stroke(255);
      line(x,y,oldX,oldY);
    }
    if((!launched)&&(exploded)&&(!hidden)){
      explodeMaths();
      noStroke();
      strokeWeight(flareWeight);
      stroke(flare);
      for(int i = 0; i < flareAmount + 1; i++){
          pushMatrix();
          translate(x,y);
          point(sin(radians(i*flareAngle))*explodeTimer,cos(radians(i*flareAngle))*explodeTimer);
          popMatrix();
       }
    }
    if((!launched)&&(!exploded)&&(hidden)){
      //do nothing
    }
  }
  ///------------------------------------------------------
  void launch()
  {
    x = oldX = (width/2) + ((random(-5,5)*100) );
    y = oldY = height;
    targetX = (width/2) + ((random(-5,5)*100) );
    targetY =  random( 10,100 ) ;
    ySpeed = random(3) + 2;
    flare = color(random(3)*50 + 105,random(3)*50 + 105,random(3)*50 + 105);
    flareAmount = ceil(random(30)) + 20;
    flareWeight = ceil(random(3));
    duration = ceil(random(4))*20 + 30;
    flareAngle = 360/flareAmount;
    launched = true;
    exploded = false;
    hidden = false;
  }
  void launchMaths()
  {
    oldX = x;
    oldY = y;
    if(dist(x,y,targetX,targetY) > 6)
    {
      x += (targetX - x)/2;
      y += -ySpeed;
    }else{
      explode();
    }
  }
  void explode()
  {
    explodeTimer = 0;
    launched = false;
    exploded = true;
    hidden = false;
  }
  void explodeMaths()
  {
    if(explodeTimer < duration){
      explodeTimer+= 0.4;
    }else{
      hide();
    }
  }
  void hide()
  {
    launched = false;
    exploded = false;
    hidden = true;
  }
}
  
  
