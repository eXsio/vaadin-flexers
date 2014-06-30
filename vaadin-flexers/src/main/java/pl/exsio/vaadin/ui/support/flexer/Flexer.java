/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;

/**
 *
 * @author exsio
 */
public interface Flexer extends Page.BrowserWindowResizeListener {
    
    Flexer addConstraint(int size, double expandRatio);
    
    Flexer removeConstraint(int size);
    
    void attach();
    
    void detach();
}
