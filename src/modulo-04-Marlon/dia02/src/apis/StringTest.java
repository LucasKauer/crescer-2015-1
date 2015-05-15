package apis;


import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {
	@Test
	public void charAtTest() throws Exception {
		String value = "cwi";
		char expected = 'c';
		
		assertEquals(expected, value.charAt(0));
	}
	
	@Test
	public void startsWithTest() throws Exception {
		String value = "cwi";
		boolean expected = true;
		
		assertEquals(expected, value.startsWith("c"));
	}
	
	@Test
	public void endsWithTest() throws Exception {
		String value = "cwi";
		boolean expected = true;
		
		assertEquals(expected, value.endsWith("i"));
	}
	
	@Test
	public void containsTest() throws Exception {
		String value = "cwi";
		boolean expected = true;
		
		assertEquals(expected, value.contains("w"));
	}
	
	@Test
	public void compareToTest() throws Exception {
		String value = "cwi";
		String valueTwo = "software";
		int expected = -16;
		
		assertEquals(expected, value.compareTo(valueTwo));
	}
	
	@Test
	public void toUpperCaseTest() throws Exception {
		String value = "cwi";
		String expected = "CWI";
		
		assertEquals(expected, value.toUpperCase());
	}
	
	@Test
	public void indexOfTest() throws Exception {
		String value = "Projeto Crescer - Crescer-2015-1";
		int expected = 8;
		
		assertEquals(expected, value.indexOf("Crescer"));
	}
	
	@Test
	public void replaceTest() throws Exception {
		String value = "Projeto Crescer";
		String expected = "Projeto_Crescer";
		
		assertEquals(expected, value.replace(" ", "_"));
	}
	
	@Test
	public void splitTest() throws Exception {
		String value = "Projeto_Crescer";
		String expected[] = {"Projeto", "Crescer"};
		String actual[] = value.split("_");
		
		assertEquals(expected, actual);
	}
}
