package com.demo.stateful;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class LibraryStatefulBean
 */
@Stateful
@LocalBean
public class LibraryStatefulBean implements LibraryStatefulBeanRemote {

List<String> bookShelf;
	
    /**
     * Default constructor. 
     */
    public LibraryStatefulBean() {
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public void addBook(String bookName) {
		bookShelf.add(bookName);
		
	}

	@Override
	public List<String> getBooks() {
		return bookShelf;
	}

}
