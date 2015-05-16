package apis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	@Test
	public void getTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");
		String expected = "apple";
		
		assertEquals(expected, actual.get("fruits") );
	}
	
	@Test
	public void putTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");
		String expected = "apple";
		
		assertEquals(expected, actual.get("fruits") );
	}
	
	@Test
	public void isEmptyTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		boolean expected = true;
		
		assertEquals(expected, actual.isEmpty());
	}
	
	@Test
	public void putAllTest() throws Exception {
		Map<String, String> aux = new HashMap<String, String>();
		aux.put("fruits", "apple");
		aux.put("fruitsTwo", "banana");
		
		Map<String, String> actual = new HashMap<String, String>();
		actual.putAll(aux);
		
		String expected = "apple";
			
		assertEquals(expected, actual.get("fruits"));
	}
	
	@Test
	public void clearTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");
		actual.clear();
		boolean expected = true;
		
		assertEquals(expected, actual.isEmpty());
	}
	
	@Test
	public void sizeTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");

		int expected = 2;
		
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void containsKeyTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");

		boolean expected = true;
		
		assertEquals(expected, actual.containsKey("fruits"));
	}
	
	@Test
	public void containsValueTest() throws Exception {
		Map<String, String> actual = new HashMap<String, String>();
		actual.put("fruits", "apple");
		actual.put("fruitsTwo", "banana");

		boolean expected = true;
		
		assertEquals(expected, actual.containsKey("fruits"));
	}
}
