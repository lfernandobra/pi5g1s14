package edu.gaed.dao;

import javax.persistence.EntityManager;

import edu.gaed.vo.UF;

public class UFDao2 extends GenericDAO<Long, UF>{
	public UFDao2(EntityManager entityManager) {
        super(entityManager);
    }
}
