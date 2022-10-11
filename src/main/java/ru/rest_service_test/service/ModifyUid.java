package ru.rest_service_test.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest_service_test.model.Response;

@Service
@Qualifier
public class ModifyUid implements MyModifyService{
    @Override
    public Response modify(Response response) {

        response.setUid("New Uid");
        return response;
    }
}
