package org.profamilia.hc.toolbox.query;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class OrQueryFilterGroup implements QueryFilter {

    private List<QueryFilter> queryFilters;

    public OrQueryFilterGroup(Collection<QueryFilter> queryFilters) {
        this.queryFilters = new ArrayList<QueryFilter>(queryFilters);
    }

    public Criterion assembleHibernateCriterion() {
        if(queryFilters == null || queryFilters.size() == 0)
            return null;
        if(queryFilters.size() == 1)
            return queryFilters.get(0).assembleHibernateCriterion();
        
        Criterion resultingCriterion = queryFilters.get(0).assembleHibernateCriterion();
        
        for(int i = 1; i < queryFilters.size(); i++) {
            resultingCriterion = Restrictions.or(resultingCriterion, 
                    queryFilters.get(i).assembleHibernateCriterion());
        }
        
        return resultingCriterion;
    }
}
