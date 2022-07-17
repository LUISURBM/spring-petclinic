package org.profamilia.hc.toolbox.query;

import org.hibernate.criterion.Order;

public class QueryOrder {
    
    private String property;
    
    private boolean ascending;
    
    public QueryOrder(String property, boolean ascending) {
        this.property = property;
        this.ascending = ascending;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public boolean isAscending() {
        return ascending;
    }
    
    public Order assembleOrder() {
        if(ascending)
            return Order.asc(property);
        
        return Order.desc(property);
    }
}
