package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import org.springframework.stereotype.Repository;


@Repository
public class RequestDaoImpl extends BaseDao <Request> implements RequestDao <Request>  {

}
