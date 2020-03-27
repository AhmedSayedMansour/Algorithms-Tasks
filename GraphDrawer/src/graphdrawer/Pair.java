/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdrawer;

/**
 *
 * @author ahmed
 */
public class Pair {
    String a,b;
    Pair(String a,String b){
        this.a = a;
        this.b = b;
    }
    String getKey(){
        return a;
    }
    String getValue(){
        return b;
    }
}
