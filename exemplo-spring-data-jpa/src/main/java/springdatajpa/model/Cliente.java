package springdatajpa.model;

import springdatajpa.model.cliente.Endereco;
import springdatajpa.model.cliente.Telefone;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "dt_nascto")
    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(name="tab_cliente_email",
            joinColumns=@JoinColumn(name = "cliente_id", referencedColumnName = "id"))
    @Column(name="email")
    private List<String> emails = new ArrayList<String>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    /**prq não usa o objeto Profissao
    /e as anotações @ManyToOne ??
    @Column(name = "profissao_id")
    private Integer profissao;

    */
    @ManyToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
}
