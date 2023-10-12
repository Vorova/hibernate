package com.vorova;

import com.vorova.config.HibernateUtil;
import com.vorova.entity.Company;
import com.vorova.entity.User;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class HibernateRunnerTest {

    @Test
    void checkReflectionAPI () {
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = session.get(Company.class, 11);

        session.getTransaction().commit();
    }
}