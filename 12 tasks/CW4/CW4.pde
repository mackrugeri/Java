import uk.ac.northumbria.dalton.Assessment4; 
import java.time.LocalDateTime; 
import java.time.LocalTime;
import java.time.Month;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

void setup()
{ 
  size(640, 480  );   
  assessmentSetup( ) ; 

  Assessment4.setUp("MY NAME", "W3030202", this); 
  Assessment4.markAll();
  afterMarking( ) ; 

  // IF YOU LIKE YOU CAN CALL  Assessment1.markQuestion1()  Assessment1.markQuestion2()...
}
//---------------------------------------------------

//--------------------------------------------------------------------------
public String  CW4A(  ) 
{
  return "THIS IS A PLACE HOLDER FOR AN ANSWER" ; 
}
//--------------------------------------------------------------------------
public int CW4B( int taxableIncome )
{ 
   return -1 ; 
}
//--------------------------------------------------------------------------
public int CW4C(  int taxableIncome, boolean  bornBefore1945, 
  boolean marriedCouplesAllowance, 
  boolean blindPersonsAllowance)
{ 
  return -1 ;
}
//--------------------------------------------------------------------------
/* 
   you should write your  CE4D  function below. 
*/ 
 
//--------------------------------------------------------------------------
public int CW4E( int healthOfEnemys[ ]  )
{  
  return 0 ;
} 
//--------------------------------------------------------------------------
// you have to write the function CW4D from scratch. 
/* Strings for you to cut and paste. 
 "Underweight" ; 
"Normal healthy weight"; 
"Overweight" ; 
  "Obese"; 
 "Morbidly obese";
  */ 
public String  CW4F( float weightInKilograms, float heighInMeters )
{ 
  return "THIS IS A PLACE HOLDER STRING FOR YOUR ANSWER" ; 
}

//--------------------------------------------------------------------------
// You variable here 
//--------------------------------------------------------------------------
public void CW4GMethod( ) 
{ 
  int nonsensecalcuation = 493* 66 % 34 - 2 / 45;
  // your code here ... 
}
//--------------------------------------------------------------------------
/*
Strings 
    January February  March
    April May  June July 
    August September October
    November December meaningless
    */ 
public String CW4H( int monthOfYear   )
{ 
  return "THIS IS A PLACE HOLDER FOR AN ANSWER" ; 
}
//------------------------------------------------------------------------------
/* 
YOUR CLASS HERE out side the comment.  
*/
public Object  CW4I ()//  replace Object with CW4JROBOT
{ 
  return new Object()   ;//  replace Object with CW4JROBOT
}
//------------------------------------------------------------------------------
public String CW4J( String A, String B, String C )
{ 
  /// format will be like this  A+","+B+","+C
  return "THIS IS A PLACE HOLDER STRING FOR YOUR ANSWER" ; 
}
//------------------------------------------------------------------------------
public int CW4K( )
{ 
  return -1 ; 
} 
//------------------------------
public boolean CW4L( int values[ ], int targetSum )
{ 
  return false ;
}

//--------------------------------------------------------------------------
/* 
 write your own functions  here if you like. 
 */
