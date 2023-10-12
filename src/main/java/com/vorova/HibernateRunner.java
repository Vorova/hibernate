package com.vorova;

import com.vorova.config.HibernateUtil;
import com.vorova.entity.Company;
import com.vorova.entity.PersonalInfo;
import com.vorova.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {
        var user = getUser();
        var company = getCompany();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

//            session.persist(company);
            user.setCompany(company);
            session.persist(user);

            session.evict(user);
            session.getTransaction().commit();
        }
    }

    private static User getUser() {
        return User.builder()
                .username("Voroba")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Vlad")
                        .lastname("Vorobyov")
                        .build())
                .birthDate(LocalDate.of(1996, 6, 14))
                .age(27)
                .build();
    }

    private static Company getCompany() {
        return Company.builder()
                .name("Yandex1")
                .build();
    }

}
