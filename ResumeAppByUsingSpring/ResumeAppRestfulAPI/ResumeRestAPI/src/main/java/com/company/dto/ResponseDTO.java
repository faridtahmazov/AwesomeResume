package com.company.dto;

public class ResponseDTO {
    private Integer errorCode;
    private String errorMsg;
    private String successMsg;
    private Object obj;

    private ResponseDTO(){}

    public static ResponseDTO of(Object obj){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObj(obj);

        return responseDTO;
    }

    public static ResponseDTO of(Object obj, String successMsg){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObj(obj);
        responseDTO.setSuccessMsg(successMsg);

        return responseDTO;
    }


    public static ResponseDTO of(Object obj, Integer errorCode, String errorMsg){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObj(obj);
        responseDTO.setErrorCode(errorCode);
        responseDTO.setErrorMsg(errorMsg);

        return responseDTO;
    }


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
