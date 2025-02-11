package org.dam48.proyectofinalbis.models;

public class ResponseModel {
    private int success;
    private String message;
    private Object data;

    public ResponseModel() {}

    public ResponseModel( int success,String message,Object data) {
        this.data = data;
        this.message = message;
        this.success = success;
    }



    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

