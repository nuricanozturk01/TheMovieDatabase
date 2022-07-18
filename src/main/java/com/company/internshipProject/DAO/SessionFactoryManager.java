package com.company.internshipProject.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
abstract public class SessionFactoryManager
{
    protected SessionFactory sessionFactory;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public SessionFactoryManager(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

}
