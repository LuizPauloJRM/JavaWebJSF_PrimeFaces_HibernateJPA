package br.com.luizsoftware.dto;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String departamento;
    private String cargo;
    private Double salario;

    public FuncionarioDTO(Long id, String nome,
                          String email, String departamento,
                          String cargo, Double salario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
        this.cargo = cargo;
        this.salario = salario;
    }
}
