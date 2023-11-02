package com.example.finalexamro37.specification;

import com.example.finalexamro37.entity.Group;
import com.example.finalexamro37.form.Group.GroupFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class GroupSpecification {
    private static final String GROUP_NAME = "groupName";
    private static final String CREATOR = "creator";
    private static final String CREATED_DATE = "createdDate";
    private static final String MIN_YEAR = "minYear";

    public static Specification<Group> buildWhere(GroupFilterForm form){
        if(form == null){
            return null;
        }
        Specification<Group> whereGroupName = new SpecificationImpl(GROUP_NAME, form.getSearch());
        Specification<Group> whereCreator = new SpecificationImpl(CREATOR, form.getSearch());
        return Specification.where(whereGroupName.or(whereCreator));
    }

    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Group>{
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case GROUP_NAME:
                    // name LIKE %value%
                    return criteriaBuilder.like(root.get("groupName"),"%" + value + "%");

                case CREATOR:
                    // tim ten trong list
//                    Join join = root.join("accounts", JoinType.LEFT);
//                    return criteriaBuilder.like(join.get("userName"), "%" + value + "%");
                        return criteriaBuilder.like(root.get("creator"), "%" + value + "%");
//                case CREATED_DATE:
//                    return criteriaBuilder.equal(root.get("createdDate").as(Date.class), (Date) value);
//
//                case MIN_YEAR:
//                    // YEAR(creatd_date) >=value
//                    return criteriaBuilder.greaterThanOrEqualTo(
//                            criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")),
//                            (Integer) value
//                    );
            }
            return null;
        }
    }
}
