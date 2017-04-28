package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import data_layer.DataModel;
import exceptions.TextbookNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Textbook;

public class Textbook_test
	{
		static Textbook mockedTextbook=mock(Textbook.class);
		static String price="$80.00";
		static String isbn="10-390890560";
		static String holdDays="Tuesdays";
		static String title="Life and Fate";
		static String author="Vasily Grossman";
		static TextbookNotFoundException mockedTBNFException=mock(TextbookNotFoundException.class);
		static ParameterBox mockedPB=mock(ParameterBox.class);
		
		
		@Test
		public void unpackTextbookData() throws TextbookNotFoundException{
			if(mockedPB.isEmpty()){
				throw new TextbookNotFoundException("ISBN: "+ this.isbn + " is not found");
			}else{
				this.title = mockedPB.get("textbooktitle");
				this.author = mockedPB.get("textbookauthor");
				this.price = mockedPB.get("textbookprice");
				this.holdDays = mockedPB.get("textbookholddays");
			}
			
		}
		
		@Test
		public void returnItems() {
			when(mockedTextbook.getPrice()).thenReturn(price);
			when(mockedTextbook.getIsbn()).thenReturn(isbn);
			when(mockedTextbook.getHoldDays()).thenReturn(holdDays);
			when(mockedTextbook.getTitle()).thenReturn(title);
			when(mockedTextbook.getHoldDays()).thenReturn(holdDays);
		}
		
		@Test (expected=TextbookNotFoundException.class)
		public void getTextbookfromData() throws TextbookNotFoundException{
			mockedPB = new DataModel().getTextbookbyISBN(isbn);
			unpackTextbookData();
		}
			
		}
