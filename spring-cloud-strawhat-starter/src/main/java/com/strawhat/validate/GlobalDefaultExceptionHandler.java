package com.strawhat.validate;

import com.strawhat.enums.ResultCodeEnum;
import com.strawhat.response.StrawhatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

/**
 *
 * 全局异常处理
 * @author lize
 * @date 2020/8/13
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler  {
    private static final Logger log= LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 处理MethodArgumentNotValidException方法参数校验异常
     *
     * @param e
     * @return StrawhatResponse 方法参数异常直接应答
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public StrawhatResponse handlerValidationException(MethodArgumentNotValidException e){
        StrawhatResponse response = new StrawhatResponse();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        ArrayList<Map<String, String>> invalidResults = new ArrayList<>();
        Iterator<FieldError> iterator = errors.iterator();

        while (iterator.hasNext()){
            FieldError fieldError = iterator.next();
            HashMap<String, String> invalidResult = new HashMap<>();
            invalidResult.put("field",fieldError.getField());
            invalidResult.put("message",fieldError.getDefaultMessage());
            invalidResults.add(invalidResult);
        }
        response.setResultCode(ResultCodeEnum.ERROR99991.getCode());
        response.setResultMsg(ResultCodeEnum.ERROR99991.getMsg());
        response.setResultContent(invalidResults);
        return response;
    }
}
