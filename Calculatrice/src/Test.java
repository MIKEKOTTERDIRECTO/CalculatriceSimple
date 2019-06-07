
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAFARI
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lecture = new Scanner(System.in);       
        System.out.println("saisissez un nombre compris entre 1 et 1 millard");
        int nbre = lecture.nextInt();
        String nb_lettre = new String();
        nb_lettre = verification_cat(nbre);
        System.out.println("Vous avez saisi: "+nb_lettre); 
       
    }
//    
//    
//    import java.util.Scanner;
//
//public class Kayembe{
    
    private static String [] unit ={ "zero","un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorse", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf"};    
    private static String [] diz = { "vingt", "trente", "quarante", "cinquante", "soixante", "septante", "quatre vingt","nonante"};
    private static String [] cent = { "cent", "mille", "million", "milliard"}; 
  
    public static String cal_diz(int z)
    {
        String value = new String();
            if(z < 20)
            {
             value = unit[z];
            }
             else if( z/10 >= 2 && z/100 < 1)
                {
            if(z % 10 == 0)
            {value = diz[(z/10)-2];}
            else
            {
        if(unit[(z%10)] == "un" && diz[(z/10)-2] != "quatre vingt")
                    value = diz[(z/10)-2]+" et "+unit[(z%10)];
          else
                    value = diz[(z/10)-2]+"-"+unit[(z%10)];}
        }        
        return value;}
    public static String cal_cent(int z)
    {
        String value = new String();
        if(z/100 >=1)
        {
            if(z % 100 == 0)
            {
                if(unit[(z/100)] == "un")
                    value = cent[0];
                else   value = unit[(z/100)]+" "+cent[0];
            }
            else
            {
                value = unit[(z/100)]+ " " + cent[0] + " " +cal_diz(z-((z/100)*100));
            }
        }
        return value;
    }
    public static String cal_mille(int z)
    {
        String value = new String();
        if(z % 1000 == 0)
        {if(z<100000)
            {value = cal_diz(z/1000)+" "+cent[1];
               if(z == 1000)
               {value = cent[1];
               }               
            }  
            else
            {value = cal_cent(z/1000)+" "+cent[1];}
        }
        else
        {if(z<100000)
            {if(z-((z/1000)*1000) >=100)
                    value = cal_diz(z/1000)+" "+cent[1]+" "+cal_cent(z-((z/1000)*1000));
                else
                    value = cal_diz(z/1000)+" "+cent[1]+" "+cal_diz(z-((z/1000)*1000));
            }else
            {
                if(z-((z/1000)*1000) >=100)
                    value = cal_cent(z/1000)+" "+cent[1]+" "+cal_cent(z-((z/1000)*1000));
                else
                    value = cal_cent(z/1000)+" "+cent[1]+" "+cal_diz(z-((z/1000)*1000));
            }
        }
        return value;
    }
    public static String cal_million(int z)
    {
        String value = new String();
        if(z%1000000 == 0)
        {
            if(z<100000000)
            {value = cal_diz(z/1000000)+" "+cent[2];}
            else
            {value = cal_cent(z/1000000)+" "+cent[2];
            }
        }
        else
        {if(z<100000000)
            {
               value = cal_diz(z/1000000)+" "+cent[2]+" "+cal_mille(z-((z/1000000)*1000000));}
            else
            {
                value = cal_cent(z/1000000)+" "+cent[2]+" "+cal_mille(z-((z/1000000)*1000000));
            }
        }
        return value;
    }
    public static String verification_cat(int nbre)
    {String rep = new String();
        if(nbre/100 < 1)
        {rep = cal_diz(nbre);}
        else if(nbre/1000 < 1)
            {rep = cal_cent(nbre);}
        else if(nbre/1000 >= 1 && nbre <1000000)
            {rep = cal_mille(nbre);}
        else if(nbre >=1000000 && nbre <1000000000)
            {rep = cal_million(nbre);}        
        return rep;
    }
    
//    public static void main(String[] args) {
       
        
//    }
}

//}
