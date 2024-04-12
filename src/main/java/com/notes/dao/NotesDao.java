package com.notes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.notes.entities.Note;

@Component
public class NotesDao {
	@Autowired
	public HibernateTemplate hibernateTemplate;

	@Transactional
	public void addNote(Note note) {
		this.hibernateTemplate.saveOrUpdate(note);
	}
//	public List<Note> getAllNotes(){
//		List<Note> list = this.hibernateTemplate.loadAll(Note.class);
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
