package org.profamilia.hc.toolbox.query;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class EqualsQueryFilter<T> implements QueryFilter {

    private String property;
    
    private T value;

    public EqualsQueryFilter(String property, T value) {
        this.property = property;
        this.value = value;
    }

    public Criterion assembleHibernateCriterion() {
        return Restrictions.eq(property, value);
    }

    public String getProperty() {
        return property;
    }

    public T getValue() {
        return value;
    }
    
    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
