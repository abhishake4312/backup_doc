package com.boeing.ps.innovationvenue.controller;

import com.boeing.ps.innovationvenue.bean.JwtRequest;
import com.boeing.ps.innovationvenue.config.JwtConfigUtil;
import com.boeing.ps.innovationvenue.config.JwtResponse;
import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;


@RestController
@RequestMapping(value="/token")
@CrossOrigin(origins = {"https://psinnovations-dev.web.boeing.com",
						 "https://psinnovations-test.web.boeing.com",
						 "https://psinnovations.web.boeing.com",
						 "http://localhost:4300",
						 "https://psinnovations-signalr-dev.web.boeing.com", 
						 "https://psinnovations-signalr-test.web.boeing.com", 
						 "https://psinnovations-signalr.web.boeing.com",
						 "http://localhost:59414"})
public class JwtAuthenticationController {

    @Autowired
    private JwtConfigUtil jwtTokenUtil;

    @Autowired
    UserProfileRepository userProfileRepository;

    private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationController.class);

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        String bemsId = authenticationRequest.getM1();
        String emailId = authenticationRequest.getM2();
        String psEmp = authenticationRequest.getM3();

        if(getInfo(bemsId)){
        	final String token = jwtTokenUtil.generateToken(new org.springframework.security.core.userdetails.User(bemsId+"~"+psEmp, emailId+"~"+getRoleDesc(bemsId),
                    new ArrayList<>()));

            LOG.info("token is: "+token);
            return new ResponseEntity(new JwtResponse(token), HttpStatus.OK);
        }
        return new ResponseEntity(new JwtResponse("Unauthorized to access."), HttpStatus.BAD_REQUEST);
    }

    private boolean getInfo(String bemsId) throws Exception
    {
        final String uri = "https://insite.web.boeing.com/culture/service/boeingUserWebServiceJSON/bemsid?query="+bemsId;
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.exchange(uri,HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String data = jsonObj.get("resultholder").toString();
        /*just a hack to count the number of records.. a response class can also be made for the same but since we only need the count, doing it this way*/
        int count = Integer.parseInt((data.split(",")[0]).split(":")[1].replaceAll("\"", ""));
        LOG.info("Result count: "+count);

        if(count>0)
            return true;
        return false;
    }

    private String getRoleDesc(String bemsId) {
        UserProfile userProfile= userProfileRepository.findByBemsId(Long.parseLong(bemsId));
        if(userProfile!=null) {
            if(userProfile.getUserRoles().getRoleId() == 1)
                return "true#nonSME";
            else{
                if(userProfile.getUserRoles().getRoleId() == 5)
                    return "false#SME";
                else{
                    return "false#nonSME";
                }
            }
        }
        return "false";
    }

    /*private String getSMEDesc(String bemsId) {
        UserProfile userProfile= userProfileRepository.findByBemsId(Long.parseLong(bemsId));
        if(userProfile!=null) {
            if(userProfile.getUserRoles().getRoleId() == 5)
                return "false~SME";
            else{
                return "false~nonSME";
            }
        }
        return "false";
    }*/
}
