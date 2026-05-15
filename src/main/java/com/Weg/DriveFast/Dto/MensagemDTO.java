package com.Weg.DriveFast.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemDTO {

    private String mensagem;

    public MensagemDTO(String mensagem) {
        this.mensagem = mensagem;
    }

}
