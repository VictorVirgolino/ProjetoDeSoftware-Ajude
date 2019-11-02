package ajude.ajude.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String email;

    private String fName;
    private String lName;
    private String nCartao;
    private String senha;

    public Usuario() {super();}

    public Usuario (String email, String fName, String lName, String nCartao, String senha){
        super();
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.nCartao = nCartao;
        this.senha = senha;
    }

public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getnCartao() {
        return nCartao;
    }

    public void setnCartao(String nCartao) {
        this.nCartao = nCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


