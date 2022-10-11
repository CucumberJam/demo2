package ru.rest_service_test.conroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rest_service_test.model.Request;
import ru.rest_service_test.model.Response;
import ru.rest_service_test.service.MyModifyService;

@Slf4j
@RestController
public class MyController {
    private final MyModifyService myModifyService;

    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService){
        this.myModifyService = myModifyService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){

        log.info("Incoming request: " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("not success")
                .errorMessage(" ")
                .build();

        Response responseAfterModify = myModifyService.modify(response);

        log.info("Out-coming response: " +String.valueOf(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
