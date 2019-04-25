/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.util.List;

/**
 *
 * @author tommib
 */
@FunctionalInterface
public interface Compute {
    
    public List modifiedList();
}
