package com.demo.entitybean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark it entity using Entity annotation 
//map table name using Table annotation
@Entity
@Table(name="books")
public class Book implements Serializable{
    
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
   private int id;
   private String name;

   public Book() {        
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }    
}