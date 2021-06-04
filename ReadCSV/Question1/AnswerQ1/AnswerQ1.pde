/*
    This is a template - 
*/ 

class MYTOPCLASS  // change this to your parent class or interface name 
{ 
  // ADD YOUR defintions here. 
  // the names of the fields should match your table column header names. 
  String toString()
  { 
     return "Items here " ; 
  } 
} 

/*
   MY FIRST CLASS here - you call call it anything you like
*/

/*
   MY SECOND CLASS here - you call call it anything you like
*/

/*
   MY THIRD CLASS here - you call call it anything you like
*/


/* 
    this is suggested function you can use to load the data into the 
    array. 
    
    you can to load the data from your first class here 
*/
void loadFile1( ArrayList<MYTOPCLASS> itemsToDisplay ) 
{ 
      String filename = dataPath("MyFILENAMEHERE1.csv"); // replace file1 with your
      //1. your code open the file here 
      //1.1 repeat for each line of the file 
          //2. your code read a line of the file here 
          
          //3. your code to turn the string into an instance of your class here 
          
          //4. your code to add the instance of you class to itemsToDisplay
      
      //5. you code to close the file or handle problems etc 
} 
/* 
    this is suggested function you can use to load the data into the 
    array. 
    
    you can to load the data from your first class here 
*/
void loadFile2( ArrayList<MYTOPCLASS> itemsToDisplay ) 
{ 
      String filename = dataPath("MyFILENAMEHERE2.csv");
      //1. your code open the file here 
      //1.1 repeat for each line of the file 
          //2. your code read a line of the file here 
          
          //3. your code to turn the string into an instance of your class here 
          
          //4. your code to add the instance of you class to itemsToDisplay
      
      //5. you code to close the file or handle problems etc 
} 
/* 
    this is suggested function you can use to load the data into the 
    array. 
    
    you can to load the data from your first class here 
*/
void loadFile3( ArrayList<MYTOPCLASS> itemsToDisplay ) 
{ 
    String filename = dataPath("MyFILENAMEHERE3.csv");
    //1. your code open the file here 
      //1.1 repeat for each line of the file 
          //2. your code read a line of the file here 
          
          //3. your code to turn the string into an instance of your class here 
          
          //4. your code to add the instance of you class to itemsToDisplay
      
      //5. you code to close the file or handle problems etc 
} 
/* 
    this is suggested function you can use to load the data into the 
    array. 
    
    you can to load the data from your first class here 
*/
void loadFile4( ArrayList<MYTOPCLASS> itemsToDisplay ) 
{ 
   String filename = dataPath("MyFILENAMEHERE3.csv");
   //1. your code open the file here 
      //1.1 repeat for each line of the file 
          //2. your code read a line of the file here 
          
          //3. your code to turn the string into an instance of your class here 
          
          //4. your code to add the instance of you class to itemsToDisplay
      
      //5. you code to close the file or handle problems etc 
  
} 

ArrayList<MYTOPCLASS> itemsToDisplay = new ArrayList<MYTOPCLASS>() ; 
void setup() 
{ 
  size( 640,480 ) ;
  // your all your files into your array 
  
  loadFile1( itemsToDisplay ) ; 
  loadFile2( itemsToDisplay ) ;
  loadFile3( itemsToDisplay ) ;
  loadFile4( itemsToDisplay ) ;
} 


void draw() 
{ 
  background(250); 
  fill(0,0,250); 
  int index = 16 ; 
  for( MYTOPCLASS it: itemsToDisplay ) 
  { 
     text( it.toString() , 20, index ); 
     index += 16; 
  } 
  
} 
