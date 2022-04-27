package com.mapping.OneToMany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Library;
import com.entities.Student;

public class OneToMany 
{
     public static void main(String[] args) 
     {
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("books_issued");
		  EntityManager em=emf.createEntityManager();
		  
		  em.getTransaction().begin();
		  
		  Library lib1=new Library();
		  lib1.setB_id(10);
		  lib1.setB_name("Java");
		  
		  Library lib2=new Library();
		  lib2.setB_id(16);
		  lib2.setB_name("CS");
		  
		  em.persist(lib1);
		  em.persist(lib2);
		  
		  ArrayList<Library> list=new ArrayList<Library>();
		  
		  list.add(lib1);
		  list.add(lib2);
		  
		  Student s1=new Student();
		  s1.setS_id(1);
		  s1.setS_name("Shwetha");
		  s1.setBooks_issued(list);
		  
		  em.persist(s1);
		  
		  em.getTransaction().commit();
		  em.close();
		  emf.close();
		  
	 }
}
