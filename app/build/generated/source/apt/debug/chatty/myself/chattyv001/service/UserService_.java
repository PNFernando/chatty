//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package chatty.myself.chattyv001.service;

import java.util.Collections;
import java.util.HashMap;
import android.content.Context;
import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.model.User;
import chatty.myself.chattyv001.service.converter.User2HttpMessageConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public final class UserService_
    implements UserService
{

    private String rootUrl;
    private RestTemplate restTemplate;

    public UserService_(Context context) {
        rootUrl = "http://192.168.1.2:8080/web/chatty/user/";
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new User2HttpMessageConverter());
    }

    @Override
    public String getRootUrl() {
        return rootUrl;
    }

    @Override
    public void setRootUrl(String arg0) {
        this.rootUrl = arg0;
    }

    @Override
    public User getUserDetailsByUserId(Long user_Id) {
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
            HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
            HashMap<String, Object> urlVariables = new HashMap<String, Object>();
            urlVariables.put("user_Id", user_Id);
            return restTemplate.exchange(rootUrl.concat("get_all_user_details_by_userId?userId={user_Id}"), HttpMethod.GET, requestEntity, User.class, urlVariables).getBody();
        }
    }

    @Override
    public ResponseMessage saveUser(User user) {
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
            HttpEntity<User> requestEntity = new HttpEntity<User>(user, httpHeaders);
            return restTemplate.exchange(rootUrl.concat("save"), HttpMethod.POST, requestEntity, ResponseMessage.class).getBody();
        }
    }

    @Override
    public User login(String email, String password) {
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
            HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
            HashMap<String, Object> urlVariables = new HashMap<String, Object>();
            urlVariables.put("password", password);
            urlVariables.put("email", email);
            return restTemplate.exchange(rootUrl.concat("login?username={email}&password={password}"), HttpMethod.POST, requestEntity, User.class, urlVariables).getBody();
        }
    }

}