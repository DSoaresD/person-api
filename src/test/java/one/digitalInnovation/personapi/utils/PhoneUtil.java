package one.digitalInnovation.personapi.utils;

import one.digitalInnovation.personapi.PhoneType;
import one.digitalInnovation.personapi.dto.resquests.PhoneDTO;
import one.digitalInnovation.personapi.entities.Phone;

public class PhoneUtil {
	
	private static final String PHONE_NUMBER = "(21)980183942";
	private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private static final Long PHONE_ID = 1L;
	
	public static PhoneDTO createFakeDTO(){
		return PhoneDTO.builder().number(PHONE_NUMBER).type(PHONE_TYPE).build();
	}

	public static Phone createFakeEntity() {
		return Phone.builder().id(PHONE_ID).number(PHONE_NUMBER).type(PHONE_TYPE).build();
	}
	
}
