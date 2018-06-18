package com.hernan.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hernan.cambioMoneda.controlador.ControladorRates;
import com.hernan.cambioMoneda.service.MonedaService;
import com.hernan.vo.Rates;
public class CambioApp {


    public void AppCambioMonedas() throws Exception {

		Rates rates = new Rates();				
		// controlador
		ControladorRates controller = new ControladorRates();
        MonedaService servicio=new MonedaService();
        String json=servicio.consumirServicio();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        String success = jsonNode.get("success").asText();
        JsonNode jsonNode2=jsonNode.get("rates");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.convertValue(jsonNode2, Map.class);
        result= new HashMap(result);
        Set set = result.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.println("insertando/actualizando: "+mentry.getKey().toString());
            rates = new Rates(mentry.getKey().toString(), mentry.getValue().toString(), "@");
            controller.registrar(rates);
         }
        
   } 

}
