package com.company.internshipProject.Dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
abstract public class EntityManagerFactory
{
    protected EntityManager entityManager;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public EntityManagerFactory(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

}
