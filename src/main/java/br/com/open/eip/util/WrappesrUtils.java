package br.com.open.eip.util;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.open.eip.entity.Produto;


public final class WrappesrUtils {


		
	public static <T> Object StringJsonToObject(String jsonInput, Object object) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonInput, (Class<T>) object);
	}
		
	public static String ObjectToJsonString(Object object) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	public static List<Object> JsonStringToObjectList(String jsonInput, Class<?> classType) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, classType.getClass()));
	}
	
	public static <T> String ObjecListToJsonString(List<T> objects) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(objects);
	}
	
	public void loadTeste() throws JsonParseException, JsonMappingException, IOException {
		Produto produto = new Produto();
		produto.setCodigoanp(1);
		produto.setCodigoif(1);
		produto.setCodprodfiscal("1");
		produto.setComplemento("complemento");
		produto.setDatahorintegracaoecommerce(new java.util.Date());
		produto.setDesccompleta("desccompleta");
		produto.setDesccomposicao("desccomposicao");
		String json = WrappesrUtils.ObjectToJsonString(produto);
		System.out.println(json);
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	  new WrappesrUtils().loadTeste();
	}		

	
}
