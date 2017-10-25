package br.com.fabricadeprogramador.service;

/**
 * Created by viniciuspodi on 20/10/17.
 */
public class ServiceException extends Throwable{

    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(String msg, Throwable causa){
        super(msg, causa);
    }
}
