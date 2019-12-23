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
public class Tree {
    
    private NodeTree root;
    
    private void addRecursive(int val, NodeTree p){
        if(p==null){
            root = new NodeTree(val);
        }else if(val>p.value){
            if(p.right!= null){
                addRecursive(val,p.right);
            } else {
                p.right = new NodeTree(val);
            }
        }else if(val<p.value){
            if(p.left!=null){
                addRecursive(val,p.left);
            } else {
                p.left = new NodeTree(val);
            }
        }
    }
    
    public void add(int val){
        addRecursive(val,root);
    }
    
    public void printRecursive(NodeTree p){
        if(p != null){
            System.out.println(p.value);
            if(p.left != null){
                printRecursive(p.left);
            }
            if(p.right != null){
                printRecursive(p.right);
            }
        }
        
            
    }
    public void print(){
        printRecursive(root);
    }
    
    public boolean findRecursive(int val, NodeTree p){
        if(p!=null){
            if(val==p.value){
                return true;
            }else{
                if(val>p.value){
                    if(p.right!=null){
                        return findRecursive(val, p.right);
                    }
                }else{
                    if(root.left!=null){
                        return findRecursive(val, p.left);
                    }
                }
            }
        }
        return false;
    }
    public boolean find(int v){
        return findRecursive(v,root);   
    }
    
    public void copyRecursive(NodeTree t){
        
    }
    
    public void copy(){
        copyRecursive(root);
    }
    
}
