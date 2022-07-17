package org.profamilia.hc.toolbox.query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

public interface QueryFilter {
    
    public abstract Criterion assembleHibernateCriterion();
}
