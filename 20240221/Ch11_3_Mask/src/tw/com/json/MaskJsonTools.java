package tw.com.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.beans.Mask;

public class MaskJsonTools {
	public static void maskJsonToObj(String json,Consumer<List<Mask>> resultCallback) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,Object> objMap = 
				(Map)objMapper.readValue(json, Map.class);
		List<Map<String,Object>> list =
				(List<Map<String,Object>>)objMap.get("features");
		List<Mask> maskList = new ArrayList();
		
		for (Map<String,Object> datMap : list) {
			 Map<String,Object> pMap = (Map<String,Object>)datMap.get("properties");
			 Mask mask = new Mask();
			 mask.setId(pMap.get("id").toString());
			 mask.setName(pMap.get("name").toString());
			 mask.setMaskAdult(pMap.get("mask_adult").toString());
			 mask.setMaskChild(pMap.get("mask_child").toString());
			 System.out.println(mask);
			 maskList.add(mask);
			 
		}
		resultCallback.accept(maskList);	
	}
}
