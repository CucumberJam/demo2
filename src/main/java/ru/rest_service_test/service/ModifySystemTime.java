package ru.rest_service_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest_service_test.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifySystemTime")
public class ModifySystemTime implements MyModifyService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime(" ");
        return response;
    }
}
