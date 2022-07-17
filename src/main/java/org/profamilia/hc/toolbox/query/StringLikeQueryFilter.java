package org.profamilia.hc.toolbox.query;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class StringLikeQueryFilter implements QueryFilter {

    private String property;
    
    private String value;
    
    private boolean caseInsensitive;

    public StringLikeQueryFilter(String property, String value, boolean caseInsensitive) {
        this.property = property;
        this.value = value;
        this.caseInsensitive = caseInsensitive;
    }

    public Criterion assembleHibernateCriterion() {
        if(caseInsensitive)
            return Restrictions.ilike(property, value);
        
        return Restrictions.like(property, value);
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    public boolean isCaseInsensitive() {
        return caseInsensitive;
    }
}
