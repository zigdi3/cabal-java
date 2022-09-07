import java.io.*;
import java.util.*;

public class Cabal
{
   private static ArrayList a; 

   public static int somaPosition(int a,int b){
      int soma;
      int anchor, anchor2;
   
      soma = a + b;      
      if( (a+b)>10 ){
         anchor2 = soma -10;
         anchor = 1;
         return anchor+anchor2;
      }
      else if (soma< 10){
         return soma;
      }else{
         return 1;
      }
   }
   
   private static void nullableObj(ArrayList x){
      a = x;
   } 

   public static int castNum(String character)
   {  
   
      char l = character.toLowerCase().charAt(0);
      int result = 0;
      
      switch(l)
      {
         case 'a':
         case 'i':
         case 'j':
         case 'q':
         case 'y':
            result = 1;
            break;
         case 'b':
         case 'k':
         case 'r':
            result = 2;
            break;
         case 'c':
         case 'g':
         case 'l':
         case 's':
            result = 3;
            break;
         case 'd':
         case 'm':
         case 't':
            result = 4;  
            break;
         case 'e':
         case 'h':
         case 'n':
            result = 5;
            break;
         case 'f':
         case 'u':
         case 'v':
         case 'w':
         case 'x':
            result = 6;
            break;
         case 'o':
         case 'z':
            result = 7;
            break;
         case 'p':
            result = 8;
            break;
      }
      return result;
   
   }
  

   public static void main (String []args)
   {
      String fullName = "Alexandre Rodrigues Vallim";
      String entry = "";
      fullName.trim();
      ArrayList full, process;
      Scanner keyboard = new Scanner(System.in);
      try{
         System.out.print("Entry a fullName: \n");
         if(keyboard.hasNextLine())
         {
         
            entry = keyboard.nextLine();
            if(entry.length()>3)
            {     fullName = entry;
            }    
            keyboard.close();
                  
         }
      }  
      finally
      {
         if(keyboard == null)
            System.out.print("error");
         keyboard.close();
      } 
      
        
      for(int ite = 0; ite < entry.length() ; ite++)
         System.out.print("  "+entry.charAt( ite ) );
   
      full = new ArrayList( );
      process = new ArrayList();
      
      for(int i = 0; i < entry.length();i++)
      {
         full.add(""+entry.charAt(i));
      }
      System.out.println();
      for(int j = 0; j < full.size();j++)
      {
         System.out.print("  "+castNum(""+full.get(j) ) );
         process.add(""+castNum(""+full.get(j) ));
      }
      
      Cabal.nullableObj(full);
      full = new ArrayList();
      full = null;
      full = new ArrayList();
      
      int pos1,pos2,iteration=0;
      while(process.size() > 1)
      {
         Cabal.nullableObj(full);
         full = new ArrayList();
         full = null;
         full = new ArrayList();
         
         System.out.println();
      
         
         for(int tab = iteration; tab>=0;tab--)
            System.out.print("  ");
            
         for(int temp = 0; temp < process.size()-1;temp++)
         {
            pos1 = Integer.parseInt(""+ process.get(temp) );
            pos2 = Integer.parseInt(""+ process.get(temp+1) );
         
            System.out.print("  " + somaPosition( pos1 , pos2 ) );
            full.add("" + somaPosition( pos1 , pos2 ) );
         }
         process = full;
         iteration++;
      }
   }


}