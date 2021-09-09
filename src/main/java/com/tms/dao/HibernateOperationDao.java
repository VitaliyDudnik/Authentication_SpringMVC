package com.tms.dao;

import com.tms.Constants;
import com.tms.entity.Operation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Repository
public class HibernateOperationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Operation operation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    public List<Operation> getAll() {
        List<Operation> operationList = new ArrayList<>();
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<Operation> operationQuery = currentSession.createQuery(Constants.CALC_GET_ALL_OPERATIONS, Operation.class);
            operationList = operationQuery.list();
        } catch (Exception e) {
            log.error("error" + e.getMessage());
        }
        return new ArrayList<>(operationList);
    }
}
