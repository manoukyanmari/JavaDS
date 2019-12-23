/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author Arsen
 */
public class SnahavatException extends RuntimeException{
    public int tiv;
    public String patchar;
    
    public SnahavatException(String e, int t, String p){
        tiv = t;
        patchar = p;        
    }
    
    public String getPatchar(){
        return patchar;        
    }
    
    public int getTiv(){
        return tiv;
    }
        
    
}
