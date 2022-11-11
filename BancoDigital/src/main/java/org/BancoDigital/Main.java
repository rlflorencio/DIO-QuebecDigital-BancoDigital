package org.BancoDigital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        boolean finaliza = false;
        Scanner scanner = new Scanner(System.in);
        Cliente clienteTester = new Cliente("Rafael", "Florencio", "@@", "@@");
        Conta contaTester = new ContaCorrente(clienteTester, banco);
        Conta contaTester2 = new ContaPoupanca(clienteTester, banco);
        banco.getContas().add(contaTester);
        banco.getContas().add(contaTester2);
        banco.getClientes().add(clienteTester);
        System.out.println(contaTester);

        try {
            do {
                menuInicial();
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1:
                        //Criacao de cadastro do Cliente
                        String nome;
                        String sobrenome;
                        String telefone;
                        String email;
                        System.out.println("---------------------------------------------");
                        System.out.println("---Vamos iniciar com seus dados cadastrais---");
                        System.out.println("-----Por favor informe seu primeiro nome ----");
                        nome = scanner.next();
                        System.out.println("-----Por favor informe seu sobrenome --------");
                        sobrenome = scanner.next();
                        System.out.println("-----Por favor informe seu telefone ---------");
                        telefone = scanner.next();
                        System.out.println("-----Por favor informe seu email ------------");
                        email = scanner.next();
                        //Verifica se cliente já existe
                        boolean jaTemCadastro = false;
                        Cliente cliente = null;
                        for (Cliente c : banco.getClientes()){
                            if (c.getNome().equals(nome) && c.getSobrenome().equals(sobrenome) &&
                                   c.getTelefone().equals(telefone)){
                                System.out.println("Voce já possui cadastro.");
                                jaTemCadastro = true;
                                cliente = c;
                            }
                        }
                        if (!jaTemCadastro){
                            cliente = new Cliente(nome, sobrenome, telefone, email);
                            banco.getClientes().add(cliente);
                        }
                        //Criacao de conta
                        System.out.println("----- Selecione o tipo de conta desejada ----");
                        System.out.println("----- 1- Conta Corrente     -----------------");
                        System.out.println("----- 2- Conta Poupança     -----------------");
                        System.out.println("----- 3- Conta Investimento -----------------");
                        System.out.println("----- 4- Retornar ao menu inicial -----------");
                        System.out.println("---------------------------------------------");
                        opcao = scanner.nextInt();
                        switch (opcao){
                            case 1:
                                System.out.println("---------------------------------------------");
                                System.out.println("-------Voce selecionou Conta Corrente -------");
                                ContaCorrente contac = new ContaCorrente(cliente, banco);
                                banco.getContas().add(contac);
                                System.out.println(banco.getContas());
                                System.out.println("-----Parabéns! " + nome + " sua conta foi aberta----");
                                System.out.println("Esses são os dados da sua conta:");
                                System.out.println(contac);
                                System.out.println("---------------------------------------------");
                                break;
                            case 2:
                                System.out.println("---------------------------------------------");
                                System.out.println("-------Voce selecionou Conta Poupança -------");
                                ContaPoupanca contap = new ContaPoupanca(cliente, banco);
                                banco.getContas().add(contap);
                                System.out.println("-----Parabéns! " + nome + " sua conta foi aberta----");
                                System.out.println("Esses são os dados da sua conta:");
                                System.out.println(contap);
                                System.out.println("---------------------------------------------");
                                break;
                            case 3:
                                System.out.println("---------------------------------------------");
                                System.out.println("-------Voce selecionou Conta Investimento ---");
                                ContaInvestimento contai = new ContaInvestimento(cliente, banco);
                                banco.getContas().add(contai);
                                System.out.println("-----Parabéns! " + nome + " sua conta foi aberta-----------");
                                System.out.println("Esses são os dados da sua conta:");
                                System.out.println(contai);
                                System.out.println("---------------------------------------------");
                                break;
                            case 4:
                                System.out.println("Retornando ao menu inicial...");
                                break;
                            default:
                                System.out.println("Opção invalida, escolha entre as opções disponiveis.");
                                break;
                        }
                        break;
                    case 2:
                        //Acesso à conta
                        boolean contaExiste = false;
                        int i = 0;
                        System.out.println("Informe a agencia da conta que voce deseja acessar:");
                        int agenciaScan = scanner.nextInt();
                        System.out.println("Informe o numero da conta que voce deseja acessar:");
                        int numeroScan = scanner.nextInt();
                        System.out.println("Informe o digito da conta que voce deseja acessar:");
                        int digitoScan = scanner.nextInt();
                        for (Conta contaAcessada : banco.getContas()){
                            if(contaAcessada.getAgencia() == agenciaScan && contaAcessada.getNumero() == numeroScan &&
                                    contaAcessada.getDigito() == digitoScan){
                                i = banco.getContas().indexOf(contaAcessada);
                                contaExiste = true;
                            } else {
                                continue;
                            }
                        }
                        Conta contaOrigem = banco.getContas().get(i);
                        if(contaExiste){
                            String nomeTitular = contaOrigem.cliente.getNome();
                            System.out.println("Olá " + nomeTitular + " bem vindo a sua conta");
                            System.out.println("----------------------------------");
                            System.out.println("--Escolha uma das opções abaixo---");
                            System.out.println("------1- Efetuar Deposito --------");
                            System.out.println("------2- Efetuar Saque    --------");
                            System.out.println("------3- Efetuar Transferencia ---");
                            System.out.println("------4- Visualizar Saldo --------");
                            System.out.println("------5- Retornar ao menu inicial-");
                            System.out.println("----------------------------------");
                        } else {
                            System.out.println("Conta inexistente");
                            break;
                        }
                        opcao = scanner.nextInt();
                        switch (opcao){
                            //Efetua Deposito
                            case 1:
                                System.out.println("Quanto voce deseja depositar?");
                                int valorDeposito = scanner.nextInt();
                                contaOrigem.depositar(valorDeposito);
                                System.out.println("Parabens voce depositou R$ " + valorDeposito + " na sua conta");
                                System.out.println("Seu saldo atual é de R$ " + contaOrigem.getSaldo() + ".");
                                break;
                            case 2:
                                //Efetua Saque
                                System.out.println("Quanto voce deseja sacar?");
                                int valorSaque = scanner.nextInt();
                                contaOrigem.sacar(valorSaque);
                                System.out.println("Parabens voce sacou R$ " + valorSaque + " da sua conta");
                                System.out.println("Seu saldo atual é de R$ " + contaOrigem.getSaldo() + ".");
                                break;
                            case 3:
                                //Efetua transferencia
                                boolean contaDestinoExiste = false;
                                int destino = 0;
                                System.out.println("Informe a agencia da conta de destino:");
                                int agenciaDestino = scanner.nextInt();
                                System.out.println("Informe o numero da conta de destino:");
                                int numeroDestino = scanner.nextInt();
                                System.out.println("Informe o digito da conta de destino:");
                                int digitoDestino = scanner.nextInt();
                                //Verifica se conta de destino existe
                                for (Conta contaAcessada : banco.getContas()){
                                    if(contaAcessada.getAgencia() == agenciaDestino && contaAcessada.getNumero() == numeroDestino &&
                                            contaAcessada.getDigito() == digitoDestino){
                                        destino = banco.getContas().indexOf(contaAcessada);
                                        contaDestinoExiste = true;
                                    }
                                }
                                Conta contaDestino = banco.getContas().get(destino);
                                if(contaDestinoExiste){
                                    String nomeDestino = contaDestino.getCliente().getNome();
                                    System.out.println("Voce deseja transferir para " + nomeDestino + " ?");
                                    System.out.println("----------------------------------");
                                    System.out.println("------1- Sim              --------");
                                    System.out.println("------2- Não              --------");
                                    opcao=scanner.nextInt();
                                    switch (opcao){
                                        case 1:
                                            System.out.println("Qual valor voce deseja transferir?");
                                            float valor = scanner.nextFloat();
                                            contaOrigem.transferir(valor, contaDestino);
                                            System.out.println("Seu saldo é de: " + contaOrigem.getSaldo());
                                            break;
                                        case 2:
                                            System.out.println("Retornando ao menu da conta");
                                            break;
                                        default:
                                            System.out.println("Opção invalida, escolha entre as opções disponiveis.");
                                            break;
                                    }
                                } else {
                                    System.out.println("Conta inexistente");
                                    break;
                                }
                                break;
                            case 4:
                                //Imprime saldo
                                System.out.println("Seu saldo atual é de R$ " + banco.getContas().get(i).saldo + ".");
                                break;
                            case 5:
                                System.out.println("Retornando ao menu inicial...");
                                break;
                            default:
                                System.out.println("Opção invalida, escolha entre as opções disponiveis.");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Fale conosco atraves do nosso gitHub:");
                        System.out.println("https://github.com/rlflorencio");
                        break;
                    case 4:
                        System.out.println("Até logo...");
                        finaliza = true;
                        break;
                    default:
                        System.out.println("Opção invalida, escolha entre as opções disponiveis.");
                        break;
                }
            } while(!finaliza);
        }finally {
            scanner.close();
        }
    }
    private static void menuInicial(){
        System.out.println("---------------------------------");
        System.out.println("------Bem Vindo ao RafaBank------");
        System.out.println("--Escolha uma das opções abaixo--");
        System.out.println("------1- Abertura de conta ------");
        System.out.println("------2- Acessar sua conta ------");
        System.out.println("------3- Fale Conosco(SAC) ------");
        System.out.println("------4- Sair              ------");
        System.out.println("---------------------------------");
    }

}

/*TODO
    Implementar validação de saldo disponivel para saques e transferencias
    Implementar funções especiais de conta investimento(Opções de investimento e simulações)
    Implementar função extrato
 */