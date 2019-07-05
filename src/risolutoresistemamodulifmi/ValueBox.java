/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risolutoresistemamodulifmi;

import javafx.scene.control.TextField;

/**
 *
 * @author matti
 */
public class ValueBox extends TextField  {
    public ValueBox()
    {
        this.setMaxWidth(50);
        this.setMinWidth(50);
        this.setMaxHeight(20);
        this.setMinHeight(20);
    }
    
}
