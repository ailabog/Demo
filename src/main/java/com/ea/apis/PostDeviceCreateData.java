package com.ea.apis;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostDeviceCreateData {


    public static String generateCreatePostBody(String name, String hostName, String serialNumber, String partnerAddress,
                                                String partnerContName, String partnerContEmail, String partnerType,
                                                String isStrategicPartner, String partnerStartDate, String partnerEndDate,
                                                String eaDevContactName, String eaDevContactEmail, String eaDevRequestedBy,
                                                String eaDevContactTeam, String partnerAddInformation) {
	    List<HashMap<String, String>> results = new ArrayList<>();

        HashMap<String, String> devices = new HashMap<String, String>(7);
        devices.put("name", name);
        devices.put("hostName", hostName);
        devices.put("serialNumber", serialNumber);
        devices.put("partnerAddress", partnerAddress);
        devices.put("partnerContName", partnerContName);
        devices.put("partnerContEmail", partnerContEmail);
        devices.put("partnerType", partnerType);
        devices.put("isStrategicPartner", isStrategicPartner);
        devices.put("partnerStartDate", partnerStartDate);
        devices.put("partnerEndDate", partnerEndDate);
        devices.put("eaDevContactName", eaDevContactName);
        devices.put("eaDevContactEmail", eaDevContactEmail);
        devices.put("eaDevRequestedBy", eaDevRequestedBy);
        devices.put("eaDevContactTeam", eaDevContactTeam);
        devices.put("partnerAddInformation", partnerAddInformation);

        results.add(devices);
        String json = new Gson().toJson(results);
        //System.out.println(json);
        return json;
    }
}
