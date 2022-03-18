/*package com.ea.apis;

import com.ea.utils.connectors.RestAssuredConnector;
import com.ea.utils.general.ConfigUtils;
import com.ea.utils.general.ConfigUtils.ConfigKeys;
import org.junit.Before;
import org.testng.annotations.Test;

/**
 * Create Device API call
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

/*public class API_CreateDeviceTest {

		private RestAssuredConnector connector = new RestAssuredConnector();

		private String requestBody;
		private String requestUri;

		@Before
		public void setupData() {
			String name = "";
			String hostName="";
			String serialNumber="";
			String partnerAddress="";
			String partnerContName="";
			String partnerContEmail="";
			String partnerType="";
			String isStrategicPartner="";
			String partnerStartDate="";
			String partnerEndDate="";
			String eaDevContactName="";
			String eaDevContactEmail="";
			String eaDevRequestedBy="";
			String eaDevContactTeam="";
			String partnerAddInformation="";

			requestBody = PostDeviceCreateData.generateCreatePostBody(name,  hostName,  serialNumber,  partnerAddress,
					 partnerContName,  partnerContEmail,  partnerType,
					 isStrategicPartner,  partnerStartDate,  partnerEndDate,
					 eaDevContactName,  eaDevContactEmail,  eaDevRequestedBy,
					 eaDevContactTeam,  partnerAddInformation);
			requestUri = ConfigUtils.getProperty(ConfigKeys.BASE_URL_DEVICE) + ConfigUtils.getProperty(ConfigKeys.END_URL_DEVICE);
		}

		@Test
		public void createPostDeviceTest() {
			connector.postRequest(requestUri, requestBody);
			System.out.println("requestBody: " + requestBody.toString());

		}
	}
*/
