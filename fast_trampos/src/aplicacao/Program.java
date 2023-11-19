package aplicacao;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cadastro;
import entidade.Login;
import entidade.Menu;

public class Program {

	public static void main(String[] args) {
		// tratar erro de "," para "."
		Locale.setDefault(Locale.US);

		Menu menu = new Menu();
		Cadastro cadastro = new Cadastro();
		Scanner sc = new Scanner(System.in);

		// escolha para menus / again tentar tratar loop de voltar para menu
		int escolha;
		boolean loop = true;

		while (loop) {

			menu.logo();
			System.out.println();
			System.out.println();
			System.out.println("Bem-Vindo ao Fast Trampos: " + "\nDigite 1 - Para Cadastrar novo Usuário "
					+ "\nDigite 2 - Para fazer login " + "\nDigite 3 - Para fechar o programa ");
			System.out.println();
			System.out.println();

			escolha = sc.nextInt();

			// limpar menu
			// menu.clear();

			switch (escolha) {

			case 0:
				System.out.println("\n\nTeste de loop :)\n\n");
				break;

			// Criar cadastro
			case 1:

				int n = 0;
				System.out.println();
				System.out.println();
				cadastro.criarCadastro();
				System.out.println();
				System.out.println();
				boolean again = true;
				while (again == true) {

					try {
						System.out.println("\n1 - Imprimir Dados do cliente cadastrado"
								+ "\nOutro numero - voltar ao MENU PRINCIPAL");
						n = sc.nextInt();

					} catch (InputMismatchException ex) {

						System.out.println("\nERRO - utilize apenas números para navegar pelos menus ");
						sc.next();
					}
					if (n != 1) {
						System.out.println("\nRetornando ao Menu Principal");
						again = false;

					} else {
						System.out.println();
						System.out.println();
						cadastro.imprimirCadastros();
						System.out.println();
						System.out.println();
						sc.next();
						again = false;
					}
				}

				break;

			// validação de usuario
			case 2:

				boolean loginBemSucedido = false;
				String cpf;
				int senha;

				System.out.println();
				System.out.println();
				menu.facaLogin();
				System.out.println();
				System.out.println();

				// Solicite CPF e senha ao usuário
				System.out.print("CPF: ");
				cpf = sc.next();
				System.out.println();
				System.out.print("Senha: ");
				senha = sc.nextInt();
				System.out.println();

				// Crie um objeto Login com o CPF e senha fornecidos
				Login usuarioLogin = new Login(cpf, senha);

				// Valide o login usando o método fazerLogin()
				loginBemSucedido = usuarioLogin.fazerLogin(cadastro);

				// Verifique se o login foi bem-sucedido
				if (loginBemSucedido) {
					System.out.println("\n\nLogin bem-sucedido! Acesso permitido.\n\n");

					// Limpar
					// menu.clear();

					boolean novoLoop = true;
					int novaEscolha;

					// Menu principal
					while (novoLoop) {
						menu.menu();
						System.out.println("\n\nFast Trampos: " + "\nDigite 1 - Para Cadastrar Serviços "
								+ "\nDigite 2 - Para Procurar Serviços "
								+ "\nDigite 3 - Para Comprar Plus (**Só para quem vai prestar serviços**) "
								+ "\nDigite 4 - Para fechar o programa \n\n");

						novaEscolha = sc.nextInt();

						// Limpar
						// menu.clear();

						switch (novaEscolha) {

						case 0:
							System.out.println("\n\nNovo teste de loop :D\n\n");
							break;

						// Criar serviço
						case 1:
							int m = 0;
							cadastro.criarServico();
							boolean again2 = true;
							while (again2) {

								try {
									System.out.println("\n1 - Imprimir Serviços do cliente cadastrado"
											+ "\nOutro número - voltar ao MENU PRINCIPAL");
									m = sc.nextInt();
								} catch (InputMismatchException ex) {
									System.out.println("\nERRO - utilize apenas números para navegar pelos menus ");
									sc.next();
								}
								if (m != 1) {
									System.out.println("\n\nRetornando ao Menu Principal\n\n");
									again2 = false;
								} else {
									cadastro.imprimirServico();
									sc.next();
									again = false;
								}
							}
							// Limpar
							// menu.clear();
							break;

						// imprimir serviços e contatos
						case 2:
							int menuServicos = 0;
							boolean again3 = true;

							// Limpar
							// menu.clear();

//********************************************************************************************************//
							// Outro loop
							while (again3) {
								menu.menuServicos();
								System.out.println("\n\nFast Trampos: " + "\nDigite 1 - Diaristas "
										+ "\nDigite 2 - Encanadores " + "\nDigite 3 - Mecânico "
										+ "\nDigite 4 - Pedreiros " + "\nDigite 5 - Pintores "
										+ "\nDigite 6 - Confeiteiros " + "\nDigite 7 - Para Sair "
										+ "\nDigite Qualquer outro número para voltar para menu\n\n");
								// Limpar
								// menu.clear();

								menuServicos = sc.nextInt();

//********************************************************************************************************//
								// começa outro Switch
								switch (menuServicos) {
								case 1:
									System.out.println("\n\nLista de Diaristas\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirDiaristas();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									String voltar = sc.next();

									break;
								case 2:
									System.out.println("\n\nLista de Encanadores\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirEncanadores();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									voltar = sc.next();

									break;
								case 3:
									System.out.println("\n\nLista de Mecanicos\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirMecanicos();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									voltar = sc.next();

									break;
								case 4:
									System.out.println("\n\nLista de Pedreiro\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirPedreiro();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									voltar = sc.next();

									break;
								case 5:
									System.out.println("\n\nLista de Pintores\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirPintor();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									voltar = sc.next();

									break;
								case 6:
									System.out.println("\n\nLista de Confeiteiros\n\n");
									System.out.println();

									System.out.println(
											"**********************************************************************");
									cadastro.imprimirConfeiteiro();
									System.out.println(
											"**********************************************************************");

									System.out.println("\n\nDigite qualquer número para voltar\n\n");
									voltar = sc.next();

									break;
								case 7:
									// Limpar
									// menu.clear();
									System.out.println(
											"\n\nVocê tem certeza que deseja fechar o programa? (Digite 'sim' para confirmar)\n\n");
									String confirmacao = sc.next();

									if (confirmacao.equalsIgnoreCase("sim") || confirmacao.equalsIgnoreCase("Sim")
											|| confirmacao.equalsIgnoreCase("SIM") || confirmacao.equalsIgnoreCase("s")
											|| confirmacao.equalsIgnoreCase("S")) {

										System.out.println("\n\nAté mais o/ \n\n");
										System.exit(0);
									} else {

										System.out.println("\n\nOperação cancelada. Retornando ao Menu Principal.\n\n");
										loop = true;
										// Limpar
										// menu.clear();
									}
									break;

								default:
									System.out.println("\n\nVoltando para Menu\n\n");
									again3 = false;
									break;

								}
							}
							break;
						case 3:
							System.out.println("\n\n\n\n\n************************************************");
							System.out.println("Desculpe! serviço em Manutenção");
							System.out.println("************************************************\n\n\n\n\n");
							break;

						case 4:
							// Limpar
							// menu.clear();
							System.out.println(
									"\n\nVocê tem certeza que deseja fechar o programa? (Digite 'sim' para confirmar)\n\n");
							String confirmacao = sc.next();

							if (confirmacao.equalsIgnoreCase("sim") || confirmacao.equalsIgnoreCase("Sim")
									|| confirmacao.equalsIgnoreCase("SIM") || confirmacao.equalsIgnoreCase("s")
									|| confirmacao.equalsIgnoreCase("S")) {

								System.out.println("\n\nAté mais o/ \n\n");
								System.exit(0);

							} else {

								System.out.println("\n\nOperação cancelada. Retornando ao Menu Principal.\n\n");
								loop = true;
								// Limpar
								// menu.clear();
							}
							break;

						default:
							System.out.println("\n\nSelecione um número correto.\n\n");
							loop = true;
							break;

						}
					}
					// Limpar
					// menu.clear();
				} else {
					// Limpar
					// menu.clear();
					System.out.println("\n\nLogin falhou. CPF e/ou senha inválidos. Acesso negado.\n\n");
					// Limpar
					// menu.clear();
				}
				break;

			case 3:
				System.out.println(
						"\n\nVocê tem certeza que deseja fechar o programa? (Digite 'sim' para confirmar)\n\n");
				String confirmacao = sc.next();

				if (confirmacao.equalsIgnoreCase("sim") || confirmacao.equalsIgnoreCase("Sim")
						|| confirmacao.equalsIgnoreCase("SIM") || confirmacao.equalsIgnoreCase("s")
						|| confirmacao.equalsIgnoreCase("S")) {

					System.out.println("\n\nAté mais o/ \n\n");
					System.exit(0);
				} else {

					System.out.println("\n\nOperação cancelada. Retornando ao Menu Principal.\n\n");
					loop = true;
					// Limpar
					// menu.clear();
				}
				break;

			default:
				System.out.println("\n\nSelecione um número correto.\n\n");
				loop = true;
				break;

			}// fim switch

		}
	}
}
