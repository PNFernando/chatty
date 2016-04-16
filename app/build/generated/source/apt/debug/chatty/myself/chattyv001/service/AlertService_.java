//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package chatty.myself.chattyv001.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.model.showmodel.ShowAlert;
import chatty.myself.chattyv001.service.converter.Alert2HttpMessageConverter;
import chatty.myself.chattyv001.service.java.util.List_ShowAlert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public final class AlertService_
    implements AlertService
{

    private String rootUrl;
    private RestTemplate restTemplate;

    public AlertService_(Context context) {
        rootUrl = "http://192.168.1.2:8080/web/chatty/alert/";
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new Alert2HttpMessageConverter());
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
    public List<ShowAlert> getShowAlertByUserId(Long user) {
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
            HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
            HashMap<String, Object> urlVariables = new HashMap<String, Object>();
            urlVariables.put("user", user);
            return restTemplate.exchange(rootUrl.concat("getShowAlertByUserId?userId={user}"), HttpMethod.GET, requestEntity, List_ShowAlert.class, urlVariables).getBody();
        }
    }

    @Override
    public ResponseMessage saveAlert(chatty.myself.chattyv001.model.Alert Alert) {
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
            HttpEntity<chatty.myself.chattyv001.model.Alert> requestEntity = new HttpEntity<chatty.myself.chattyv001.model.Alert>(Alert, httpHeaders);
            return restTemplate.exchange(rootUrl.concat("save"), HttpMethod.POST, requestEntity, ResponseMessage.class).getBody();
        }
    }

}
