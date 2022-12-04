package springdatajpawebapi.model.cliente;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDateTime;

@Embeddable
public class ClienteLog {
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }
}
