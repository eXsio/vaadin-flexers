/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;

public abstract class AbstractOrderedLayoutFlexerImpl extends AbstractFlexerImpl {

    protected final AbstractOrderedLayout container;

    protected final Component subject;

    public AbstractOrderedLayoutFlexerImpl(AbstractOrderedLayout container, Component subject) {
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

    protected void setSubjectExpandRatio(int size) {
        this.container.setExpandRatio(this.subject, this.getClosestExpandRatio(size));
    }

    protected abstract int getSize();

    protected abstract int getSize(Page.BrowserWindowResizeEvent event);

}
