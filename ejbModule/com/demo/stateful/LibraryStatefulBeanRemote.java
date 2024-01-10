package com.demo.stateful;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryStatefulBeanRemote {

	void addBook(String bookName);
	List getBooks();
}
