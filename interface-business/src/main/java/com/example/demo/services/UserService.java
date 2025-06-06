package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.ClientRest;
import com.example.demo.model.request.UpdateDTO;
import com.example.demo.model.request.UserDTO;
import com.example.demo.model.response.UserResponse;

import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private final ClientRest clientRest;
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String SECRET_KEY = "claveSecretaExamenOrion05Junio25"; 

	
    public UserService(ClientRest clientRest) {
    	this.clientRest=clientRest;
      }


    public List<UserResponse> getOperacion() {
    	 
    	List<UserResponse> res= clientRest.getOperacion();
    	
        return res;
    }
    public UserResponse addOperacion(UserDTO request) {
    	 String decryptedSecreto = decrypt(request.getSecreto());
    	 request.setSecreto(decryptedSecreto);
    	UserResponse res= clientRest.saveOperacion(request);
    	
        return res;
    }
    public UserResponse updateOperacion(UpdateDTO request) {
   	 
   	UserResponse res= clientRest.updateOperacion(request);
   	
       return res;
   }
    private String decrypt(String encryptedData) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error en el descifrado", e);
        }
    }

    
}
