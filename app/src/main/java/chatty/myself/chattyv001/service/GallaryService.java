package chatty.myself.chattyv001.service;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.androidannotations.api.rest.RestClientRootUrl;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.model.Gallary;
import chatty.myself.chattyv001.service.converter.Gallary2HttpMessageConverter;

/**
 * Created by Pramoda Fernando on 4/19/2015.
 */

@Rest(rootUrl = "http://192.168.1.2:8080/web/chatty/gallary/",converters = {MappingJackson2HttpMessageConverter.class,Gallary2HttpMessageConverter.class})

public interface GallaryService extends RestClientRootUrl {

    @Post(value = "save")
    @Accept(MediaType.APPLICATION_JSON)
    ResponseMessage saveGallary(Gallary Gallary);



}
