package apis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void addTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Crescer");
		String expected = "Crescer";
		
		assertEquals(expected, actual.get(0));
	}
	
	@Test
	public void containsTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Crescer");
		Boolean expected = true;
		
		assertEquals(expected, actual.contains("Crescer"));
	}
	
	@Test
	public void getTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Crescer");
		String expected = "Crescer";
		
		assertEquals(expected, actual.get(0));
	}
	
	@Test
	public void sizeTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Projeto");
		actual.add("Crescer");
		int expected = 2;
		
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void isEmptyTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		boolean expected = true;
		
		assertEquals(expected, actual.isEmpty());
	}
	
	@Test
	public void addAllTest() throws Exception {
		List<String> aux = new ArrayList<String>();
		aux.add("Projeto");
		aux.add("Crescer");
		
		List<String> actual = new ArrayList<String>();
		actual.addAll(aux);
		
		String expected = "Crescer";
			
		assertEquals(expected, actual.get(1));
	}
	
	@Test
	public void setTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Iniciativa");
		actual.add("Crescer");
		actual.set(0, "Projeto");
		
		String expected = "Projeto";
			
		assertEquals(expected, actual.get(0));
	}
	
	@Test
	public void subListTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Dica: ");
		actual.add("eh");
		actual.add("uma");
		actual.add("linguagem");
		actual.add("linda!");
		actual.add("Java");
		actual.add("Script");
		
		int expected = 5;
		assertEquals(expected, actual.subList(0, 5).size());
	}
	
	@Test
	public void indexOfTest() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("Projeto");
		actual.add("Crescer");
		
		int expected = 1;
		assertEquals(expected, actual.indexOf("Crescer"));
	}
}
