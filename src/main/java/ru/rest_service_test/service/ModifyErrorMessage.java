package ru.rest_service_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest_service_test.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyModifyService{
    @Override
    public Response modify(Response response) {
        response.setErrorMessage("Something wrong...");
        return response;
    }
}
