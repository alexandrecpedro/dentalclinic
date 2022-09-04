package br.com.dentalclinic.service;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
class EnderecoServiceImplTest {
    /** Attributes **/
    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    static ArrayList<Endereco> listaEndereco = new ArrayList<Endereco>();


    //Funcao para comparar enderecos
    public boolean comparaEndereco(Endereco e1, Endereco e2){
        if(e1.toString().equals(e2.toString())){
            return true;
        }
        return false;
    }

    @BeforeAll
    static public void init(){

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

        listaEndereco.add(end1);
        listaEndereco.add(end2);
        listaEndereco.add(end3);
        listaEndereco.add(end4);
        listaEndereco.add(end5);
        listaEndereco.add(end6);
        listaEndereco.add(end7);
        listaEndereco.add(end8);
        listaEndereco.add(end9);
        listaEndereco.add(end10);
        listaEndereco.add(end11);
        listaEndereco.add(end12);
        listaEndereco.add(end13);
        listaEndereco.add(end14);
        listaEndereco.add(end15);
        listaEndereco.add(end16);

    }


    /** Tests **/
    @Test
    //Rotina teste insercao de enderecos
    public void salvar() {

        for(Endereco e : listaEndereco){
            enderecoServiceImpl.salvar(e);
            System.out.println(e.toString());
        }
    }

    @Test
    public void buscarTodos(){
        List<Endereco> todosEnderecosDb = enderecoServiceImpl.buscarTodos();
        if(todosEnderecosDb.size()<16){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    public void buscarById() {
        for(Endereco e : listaEndereco){
            Optional<Endereco> dbEndereco;
            dbEndereco = enderecoServiceImpl.buscarById(e.getId());
            if(!Optional.empty().isEmpty()){
                fail("Falha buscando o endereco :"+e.toString());
            }
            else{
                if(!comparaEndereco(e,dbEndereco.get())){
                    fail("Falha buscando o endereco :"+e.toString());
                }
            }
        }
    }

    @Test
    public void atualizar() {
        for(Endereco e1:listaEndereco){
            Endereco e2 = new Endereco();
            BeanUtils.copyProperties(e1,e2);
            e2.setNumero("5");
            enderecoServiceImpl.atualizar(e2);
            Endereco e3 = new Endereco();
            enderecoServiceImpl.buscarById(e2.getId());
            if(e3.getNumero()==e1.getNumero()){
                fail("Falha atualizar o numero");
            }
        }
    }

    @Test
    public void deletar() {
        for(Endereco e:listaEndereco){
            enderecoServiceImpl.deletar(e.getId());
        }
        List<Endereco> enderecosDb = enderecoServiceImpl.buscarTodos();
        if(enderecosDb.size()>0){
            fail("Falha ao deletar entradas.");
        }
    }
}