package br.edu.ifpb.padroes.service.mail;


import java.io.File;

public interface EventListener {

    void update(String eventType, File file);

}