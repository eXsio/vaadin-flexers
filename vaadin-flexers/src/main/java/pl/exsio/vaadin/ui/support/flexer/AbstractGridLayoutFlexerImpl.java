/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;
import com.vaadin.ui.GridLayout;

public abstract class AbstractGridLayoutFlexerImpl extends AbstractFlexerImpl {

    protected final GridLayout container;

    protected final int subject;

    public AbstractGridLayoutFlexerImpl(GridLayout container, int subject) {
        this.container = container;
        this.subject = subject;
    }

    @Override
    public void attach() {
        super.attach();
        this.setSubjectExpandRatio(this.getSize());

    }

    @Override
    public void browserWindowResized(Page.BrowserWindowResizeEvent event) {
        this.setSubjectExpandRatio(this.getSize(event));
    }

    protected abstract void setSubjectExpandRatio(int size);

    protected abstract int getSize();

    protected abstract int getSize(Page.BrowserWindowResizeEvent event);

}
