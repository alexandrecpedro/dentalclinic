package br.com.dentalclinic.service;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.repository.EnderecoRepository;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoServiceImplTest {
    /** Attributes **/
    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    //EnderecoServiceImpl enderecoServiceImpl = new EnderecoServiceImpl();

    /** Tests **/
    @Test
    //Rotina teste insercao de enderecos
    public void salvar() {
        Endereco end1 = new Endereco("Rua Germano Vítor dos Santos", "598", "CASA 013", "Morumbi", "LOCALIDADE 1", "SP", "00000-001");
        Endereco end2 = new Endereco("Rua Glucínio", "598", "AP. 15", "Barra Funda‎", "LOCALIDADE 2", "MG", "00000-002");
        Endereco end3 = new Endereco("Rua Nelson Ferreira", "598", "bloco c. ap.15", "Bela Vista‎", "LOCALIDADE 3", "AC", "00000-003");
        Endereco end4 = new Endereco("Rua Clodomiro Pinheiro", "598", "CASA 014", "Belém‎", "LOCALIDADE 4", "RJ", "00000-004");
        Endereco end5 = new Endereco("Rua Emí­lio Retrosi", "598", "AP. 16", "Bom Retiro‎", "LOCALIDADE 5", "PR", "00000-005");
        Endereco end6 = new Endereco("Praça Antônio Pereira Martins", "598", "bloco c. ap.16", "Brasilândia‎", "LOCALIDADE 6", "RS", "00000-006");
        Endereco end7 = new Endereco("Rua Comendador Assad Abdalla", "598", "CASA 015", "Butantã‎", "LOCALIDADE 7", "SP", "00000-007");
        Endereco end8 = new Endereco("Rua Ouro Verde", "598", "AP. 17", "Barra Funda‎", "LOCALIDADE 8", "MG", "00000-008");
        Endereco end9 = new Endereco("Rua Casa da Boavista", "598", "bloco c. ap.17", "Bela Vista‎", "LOCALIDADE 9", "AC", "00000-009");
        Endereco end10 = new Endereco("Rua John Redford", "598", "CASA 016", "Belém‎", "LOCALIDADE 10", "RJ", "00000-010");
        Endereco end11 = new Endereco("Avenida Nazaré", "598", "AP. 18", "Bom Retiro‎", "LOCALIDADE 11", "PR", "00000-011");
        Endereco end12 = new Endereco("Avenida Adelino Jorge Montenegro", "598", "bloco c. ap.18", "Brasilândia‎", "LOCALIDADE 12", "RS", "00000-012");
        Endereco end13 = new Endereco("Rua Rynaldo Borgianni", "598", "CASA 017", "Butantã‎", "LOCALIDADE 13", "SP", "00000-013");
        Endereco end14 = new Endereco("Rua Arvore da Cera", "598", "AP. 19", "Barra Funda‎", "LOCALIDADE 14", "MG", "00000-014");
        Endereco end15 = new Endereco("Rua Acioli Monteiro", "598", "bloco c. ap.19", "Bela Vista‎", "LOCALIDADE 15", "AC", "00000-015");
        Endereco end16 = new Endereco("Rua Manuel Teles Vitancos", "598", "CASA 018", "Belém‎", "LOCALIDADE 16", "RJ", "00000-016");

        enderecoServiceImpl.salvar(end1);
        enderecoServiceImpl.salvar(end2);
        enderecoServiceImpl.salvar(end3);
        enderecoServiceImpl.salvar(end4);
        enderecoServiceImpl.salvar(end5);
        enderecoServiceImpl.salvar(end6);
        enderecoServiceImpl.salvar(end7);
        enderecoServiceImpl.salvar(end8);
        enderecoServiceImpl.salvar(end9);
        enderecoServiceImpl.salvar(end10);
        enderecoServiceImpl.salvar(end11);
        enderecoServiceImpl.salvar(end12);
        enderecoServiceImpl.salvar(end13);
        enderecoServiceImpl.salvar(end14);
        enderecoServiceImpl.salvar(end15);
        enderecoServiceImpl.salvar(end16);


    }

    @Test
    public void buscarById() {}

    @Test
    public void atualizar() {}

    @Test
    public void deletar() {}
}