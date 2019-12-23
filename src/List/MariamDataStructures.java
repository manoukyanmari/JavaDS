/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author Elya
 */
public class MariamDataStructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tree t = new Tree();
        t.add(50);
        t.add(40);
        t.add(80);
        t.add(30);
        t.add(60);
        t.add(8);
        t.add(150);
        t.add(5000);
        t.add(500);
        System.out.println(t.find(60));
        System.out.println(t.find(8));
        System.out.println(t.find(199));
        t.print();
    }
    
}
