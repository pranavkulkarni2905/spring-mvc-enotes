package com.notes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.notes.entities.User;

@Component
public class UserDao {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}

	public User findByUsernameAndPassword(String email, String password) {
		List<User> users = (List<User>) this.hibernateTemplate.findByNamedQueryAndNamedParam(
				"User.findByUsernameAndPassword", new String[] { "email", "password" },
				new Object[] { email, password });
		return users.isEmpty() ? null : users.get(0);
	}

//	public List<Product> getAllProducts(){
//		List<Product> list = this.hibernateTemplate.loadAll(Product.class);
//		return list;
//	}
//	
//	@Transactional
//	public void deleteProduct(int id) {
//		Product product = this.hibernateTemplate.get(Product.class, id);
//		this.hibernateTemplate.delete(product);
//	}
//	
//	
//	public Product getSingleProduct(int id) {
//		return this.hibernateTemplate.get(Product.class, id);
//	}

}
