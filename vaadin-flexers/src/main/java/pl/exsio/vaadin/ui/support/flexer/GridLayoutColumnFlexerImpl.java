/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;
import com.vaadin.ui.GridLayout;

/**
 *
 * @author exsio
 */
public class GridLayoutColumnFlexerImpl extends AbstractGridLayoutFlexerImpl {

    public GridLayoutColumnFlexerImpl(GridLayout container, int subject) {
        super(container, subject);
    }

    @Override
    protected void setSubjectExpandRatio(int size) {
        this.container.setColumnExpandRatio(this.subject, this.getClosestExpandRatio(size));
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
