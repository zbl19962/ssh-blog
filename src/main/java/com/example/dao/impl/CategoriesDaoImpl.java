package com.example.dao.impl;

import com.example.dao.CategoriesDao;
import com.example.pojo.Blog;
import com.example.pojo.Categories;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 21:18
 * Talk is cheap. Show me the code.
 */
@Repository
public class CategoriesDaoImpl implements CategoriesDao {
    @Resource
    private SessionFactory sessionFactory;
    private HibernateTemplate ht;
    private Session session;
    private List<Categories> list;

    @Autowired
    public CategoriesDaoImpl(SessionFactory sessionFactory) {
        // TODO Auto-generated constructor stub
        this.sessionFactory=sessionFactory;
        this.ht = new HibernateTemplate(sessionFactory);
        this.session=sessionFactory.openSession();

    }

    public void save(Categories categories) {
        ht.save(categories);
    }

    @SuppressWarnings("unchecked")
    public List<Categories> findAll() {
        String hql = "from Categories";
        Query query=session.createQuery(hql);
        list=query.list();
        if (list.size()>0){
            return list;
        }else {
            return null;
        }
    }
}