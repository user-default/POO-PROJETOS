import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Principal
{
	public static void main(String []args) throws IOException
	{
		String path = "/home/user/example.txt";
		Scanner teclado = new Scanner(System.in);
		int insere = 1, exibe = 2, apaga = 3, i = 0;
		System.out.println("Manipulador de arquivos de textos iniciado!\n");
		System.out.println("Opções:\n1 - Para Inserir caracteres no arquivo;\n2 - Exibir todos os nomes contidos no arquivo;\n3 - Apagar todo o arquivo;\n0 - Para encerrar o programa;\n");		
		while(1 != 0)
		{
			System.out.println("Digite uma das opções:\n");
			i  = teclado.nextInt();
			if(i == 0)
			{
				System.out.println("Fim de execução!\n");
				System.exit(0);
			}	
			else if(i == insere)
			{
				ManipuladorDeArquivos.escritor(path);
			}
			else if(i == exibe)
			{
				ManipuladorDeArquivos.leitor(path);
			}
			else if(i == apaga)
			{
				ManipuladorDeArquivos.apagador(path);
			}
			else
				System.out.println("Opção inválida!\n");
			
		}

	}

}


class ManipuladorDeArquivos
{
	public static void leitor(String path) throws IOException
	{
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (1 != 0)
		{
			if (linha != null)
			{
				System.out.println(linha);
			}
			else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	public static void escritor(String path) throws IOException
	{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		linha = input.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
	
	public static void apagador(String path) throws IOException
	{
		BufferedWriter buffClear = new BufferedWriter(new FileWriter(path));
		buffClear.append("");
		buffClear.close();
	}

}
