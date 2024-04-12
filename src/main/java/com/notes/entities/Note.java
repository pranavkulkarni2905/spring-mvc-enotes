package com.notes.entities;

import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@javax.persistence.Table
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String title;
	public String desc;
	public Date date;
	
	
	public Note(int id, String title, String desc, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", desc=" + desc + ", date=" + date + "]";
	}
}
