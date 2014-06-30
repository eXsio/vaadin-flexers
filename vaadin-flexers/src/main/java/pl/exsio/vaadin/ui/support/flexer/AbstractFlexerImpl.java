/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.exsio.vaadin.ui.support.flexer;

import com.vaadin.server.Page;
import java.util.NavigableMap;
import java.util.TreeMap;


public abstract class AbstractFlexerImpl implements Flexer {

    protected final NavigableMap<Integer, Double> constraintsMap;
    
    public AbstractFlexerImpl() {
        this.constraintsMap = new TreeMap<>();
    }
    
    @Override
    public Flexer addConstraint(int size, double expandRatio) {
        this.constraintsMap.put(size, expandRatio);
        return this;
    }

    @Override
    public Flexer removeConstraint(int size) {
        this.constraintsMap.remove(size);
        return this;
    }

    @Override
    public void attach() {
        Page.getCurrent().addBrowserWindowResizeListener(this);
    }

    @Override
    public void detach() {
        Page.getCurrent().removeBrowserWindowResizeListener(this);
    }
    
    protected float getClosestExpandRatio(int size) {
        if(this.constraintsMap.size() > 0) {
            int nearestSize = 0;
            for(int constraintSize: this.constraintsMap.navigableKeySet()) {
                if(size > constraintSize) {
                    nearestSize = constraintSize;
                }
            }
            if(this.constraintsMap.containsKey(nearestSize)) {
                return this.constraintsMap.get(nearestSize).floatValue();
            } else {
                return this.constraintsMap.get(this.constraintsMap.navigableKeySet().first()).floatValue();
            }
        } else {
            return 1;
        }
    }
    
}
