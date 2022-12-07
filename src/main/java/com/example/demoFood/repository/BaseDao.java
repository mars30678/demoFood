package com.example.demoFood.repository;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {
	
	
	
	@PersistenceContext
    private EntityManager entityManager ;
	@SuppressWarnings({"unchecked","rawtypes"})
	protected <EntityType> List<EntityType> doQuery(String sql,Map<String,Object>params,Class<EntityType> clazz){//無分頁比數
		Query query = entityManager.createQuery(sql,clazz);
		if(!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet 遍歷取值
//			for(Entry<String,Object> item :params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p :query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.getResultList();
	}
}
