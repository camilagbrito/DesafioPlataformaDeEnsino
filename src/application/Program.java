package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem no curso? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Dados da " + (i+1) + "a aula: ");
			System.out.print("Conteúdo ou tarefa (c/t): ");
			char resp = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if( resp == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				list.add(new Video(title, url, duration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int qnt = sc.nextInt();
				list.add(new Task(title, description, qnt));
			}
		}
		
		int sum = 0;
		for (Lesson l : list) {
			sum += l.duration();
		}
		
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
		
		sc.close();
	}

}
