package com.strawhat.validate;

import com.strawhat.annotation.validate.DateTime;
import com.strawhat.utils.core.date.DateUtil;
import com.strawhat.utils.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 *
 *
 * 日期格式校验类
 * @author lize
 * @date 2020/8/13
 */
public class DateTimeValidator implements ConstraintValidator<DateTime, String> {
    private String format="yyyyMMddHHmmss";
    private boolean required=false;

    /**
     * 初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(DateTime constraintAnnotation) {
        this.required=constraintAnnotation.required();
        if (!StrUtil.isEmpty(constraintAnnotation.format())){
            this.format=constraintAnnotation.format();
        }
    }

    /**
     * 校验时间格式是否正确
     * @param str   被校验的时间字符串
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {
        if (this.required && StrUtil.isEmpty(str)){
            context.buildConstraintViolationWithTemplate("该值为必输值").addConstraintViolation();
            return false;
        }else if(StrUtil.isEmpty(str) && !this.required){
            return true;
        }else {
            try {
                Date date = DateUtil.parse(str, this.format);
                return str.equals(DateUtil.format(date, this.format));
            }catch (Exception e){
                return false;
            }
        }
    }
}
