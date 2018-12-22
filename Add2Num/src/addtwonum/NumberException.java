/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addtwonum;

/**
 *
 * @author Hy's PC
 */
public class NumberException extends NumberFormatException {
      private int pos;
    
    public NumberException(int num) {
        pos = num;
    }
    
    @Override
    public String toString() {
        return pos + "";
    }
    
}
