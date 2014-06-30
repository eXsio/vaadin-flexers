/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;

/**
 *
 * @author exsio
 */
public class OrderedLayoutWidthFlexerImpl extends AbstractOrderedLayoutFlexerImpl {

    public OrderedLayoutWidthFlexerImpl(AbstractOrderedLayout container, Component subject) {
        super(container, subject);
    }

    @Override
    protected int getSize() {
        return Page.getCurrent().getBrowserWindowWidth();
    }

    @Override
    protected int getSize(Page.BrowserWindowResizeEvent event) {
        return event.getWidth();
    }

    
    
}
