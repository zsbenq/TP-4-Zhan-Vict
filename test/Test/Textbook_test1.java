package Test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.TextbookNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Textbook;

public class Textbook_test1
	{

		Textbook mockedTextbook;
		String price="$80.00";
		String isbn="10-390890560";
		String holdDays="Tuesdays";
		String title="Life and Fate";
		String author="Vasily Grossman";
		TextbookNotFoundException mockedTBNFException;
		ParameterBox mockedPB;
		

		@Test (expected=NullPointerException.class)
		public void testGetterMethods() throws TextbookNotFoundException{
			fail(mockedTextbook.getIsbn()); //should fail because of format
			assertEquals(mockedTextbook.getAuthor(), "Vassily Grossman");
			assertEquals(mockedTextbook.getPrice(), price);
			assertEquals(mockedTextbook.getTitle(), title);
			assertEquals(mockedTextbook.getTextbookbyISBN(isbn), isbn);
			
		}
		

	}
